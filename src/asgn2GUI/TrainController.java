package asgn2GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.print.attribute.standard.DateTimeAtCompleted;

import asgn2Exceptions.TrainException;

public class TrainController {

	private TrainModel model;
	
	private TrainGUI view;
	
	private Integer totalWeight;
	
	public TrainController(TrainModel model, TrainGUI gui) {
		this.model = model;
		this.view = gui;
		totalWeight = 0;
		gui.addActionListener(new TrainListener());
		
	}
	

	private String newline = "\n";
	
	private String getDriverInfo(){
		String info = "====== INFO FOR DRIVER =====" + newline + newline;
		info += "train configuration = " + model.getConfigurationName() + newline;
		info += "total power = " + model.getPower().toString() + newline;
		info += "total weight = " + totalWeight.toString() + newline; 
		info += " ------------------------------------ -" + newline;
		Integer allowedAddWeight = model.getPower() - totalWeight;
		if(allowedAddWeight < 0){
			info += "WARNING!!! OVERLOADED - CANNOT MOVE" + allowedAddWeight.toString() 
					+ " tonnes" + newline;
		}
		else {
			info += "allowed additional grossweight = " + allowedAddWeight.toString() + 
					" tonnes" + newline;
		}
		
		Integer numOnBoard = model.getNumberOnBoard(); 
		if(numOnBoard != 0){
			info += "WARNING !!! adding a carriage is not allowed because there are passenger on board" +
		" (" + numOnBoard.toString() + " people)" + newline;
		}
		info += "===============" + newline;
		return info;
	}
	
	private String getConductorInfo(){
		String info = "=========== INFO FOR CONDUCTOR ======" + newline + newline;
		
		info += "Total Number of Seats = " + model.getNumberOfSeats().toString() + newline;
		info += "Total Passengers = " + model.getNumberOnBoard().toString() + newline;
		
		Integer allowedAddPass = model.getNumberOfSeats() - model.getNumberOnBoard();
		info += "Allowed additional passengers = " + allowedAddPass.toString() + " people" + newline;
		info += "=============" + newline;
		return info;
	}
	
	private class TrainListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Component source = (Component) e.getSource();
			if(source == view.getAddCarriageBtn()){
				addCarriage();
				
			} 
			else if(source == view.getRemoveCarBtn()){
				removeCarriage();
			} 
			else if(source == view.getBoardBtn()){
				boardPsg();
			}
			setBtnBoardEnable();
		}
		
		private void removeCarriage() {
			try{
				model.removeCarriage();
				view.updateDriverInfo(getDriverInfo());
				view.updateConductorInfo(getConductorInfo());
			} catch(TrainException e){
				view.showErrorMessage(e.toString());
			}
		}

		private void addCarriage(){
			String userChoosen = view.chooseCar(model.getCarriageType());
			if(userChoosen!=null){
				switch(userChoosen){
					case "Locomotive" : settingLocomotive(); break;
					case "Passenger Car" : settingPassengerCar(); break;
					case "Freight Car" : settingFreightCar(); break;
				}
			}
		}

		private void settingLocomotive() {
			String[] engineType = model.getLocoEngineType();
			String[] enginePower = model.getLocoPower();
			Object[] locoParams = view.settingLocomotive(engineType, enginePower);
			if(locoParams != null){
				String locoType = locoParams[2].toString() + locoParams[1].toString().substring(0,1);
				Integer grsWeight = (Integer)locoParams[0];
				totalWeight += grsWeight;
				try {
					model.addLocomotive( grsWeight, locoType);
					view.updateDriverInfo(getDriverInfo());
				} catch (TrainException e) {
					view.showErrorMessage(e.toString());
				}
			}
			else {
				view.showErrorMessage("Invalid parameter(s)");
			}
		}
		
		
		
		
		public void settingPassengerCar() {
			Integer[] passengerCarParams = view.settingPassengerCar();
			if(passengerCarParams != null){
				Integer grossWeight = passengerCarParams[0];
				Integer numberOfSeats = passengerCarParams[1];
				totalWeight += grossWeight;
				try{
					model.addPassengerCar(grossWeight, numberOfSeats);
					view.updateDriverInfo(getDriverInfo());
					Integer totalNumOfSeats = model.getNumberOfSeats();
					view.setTxtNumOfSeats(totalNumOfSeats);
					view.updateConductorInfo(getConductorInfo());
				} catch (TrainException e){
					view.showErrorMessage(e.toString());
				}
			}
			else {
				view.showErrorMessage("Invalid parameter(s)");
			}
		}

		public void settingFreightCar() {
			String[] goodsTypeToChoice = model.getFreightCarGoodsType();
			Object[] freightCarParams = view.settingFreightCar(goodsTypeToChoice);
			if(freightCarParams != null){
				Integer grossWeight = (Integer)freightCarParams[0];
				String goodsType = (String)freightCarParams[1];
				String goodsTypeToInput = goodsType.substring(0, 1); 
				totalWeight += grossWeight;
				try{
					model.addFreightCar(grossWeight, goodsTypeToInput);
					view.updateDriverInfo(getDriverInfo());
				} catch (TrainException e){
					view.showErrorMessage(e.toString());
				}
			}
			else {
				view.showErrorMessage("Invalid parameter(s)");
			}
		}

	}

	public void setBtnBoardEnable() {
		if(model.getNumberOfSeats() > 0 || model.getNumberOfSeats() > model.getNumberOnBoard()){
			view.setBoardbtnEnable(true);
		}
		else {
			view.setBoardbtnEnable(false);
		}
	}

	public void boardPsg() {
		Integer passengers = view.addPassengers();
		Integer numUnableToBoard = 0;
		
		try{
			numUnableToBoard = model.board(passengers);
		} catch(TrainException e){
			view.showErrorMessage(e.toString());
		}
		
		if(numUnableToBoard > 0){
			String psgCannotBoarding = "Overloaded !!! " + numUnableToBoard + " people cannot board " + newline;
			view.showErrorMessage(psgCannotBoarding);
			view.updateConductorInfo(psgCannotBoarding);
			
		}
		view.updateConductorInfo(getConductorInfo());
		view.setNumOnBoard(model.getNumberOnBoard());
	}

}
