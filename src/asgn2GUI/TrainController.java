package asgn2GUI;

import java.awt.*;
import java.awt.event.*;
import asgn2Exceptions.TrainException;

public class TrainController{

	private TrainModel model;
	
	private TrainGUI view;
	
	private String newline = "\n";
	
	
	public TrainController(TrainModel model, TrainGUI gui) {
		this.model = model;
		this.view = gui;
		gui.addActionListener(new TrainListener());
		
	}
	

	
	
	
	/**
	 * Implementation class of Action Listener
	 * */
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
			else if(source == view.getResetBtn()){
				resetGame();
			}
			view.setBoardbtnEnable(model.isContainPassengersCar());
			
		}
		
		private void resetGame() {
			model.newTrain();
			view.resetGame();
		}

		private void removeCarriage() {
			try{
				
				model.removeCarriage();
				view.updateDriverInfo(model.getDriverInfo());
				view.updateConductorInfo(model.getConductorInfo());
				view.removeImage();
			
			} catch(TrainException e){
			
				view.showErrorMessage(e.toString());
			}
		}

		/**
		 * 
		 * */
		private void addCarriage(){
			String userChoosen = view.chooseCar(model.getCarriageType());
			if(userChoosen!=null){
				switch(userChoosen){
					case "Locomotive" : settingLocomotive(); break;
					case "Passenger Car" : settingPassengerCar(); break;
					case "Freight Car" : settingFreightCar(); break;
				}
				view.updateDriverInfo("pass Add Carriage / Testing");
			}
		}

		/**
		 * 
		 * */
		private void settingLocomotive() {
			String[] engineType = model.getLocoEngineType();
			String[] enginePower = model.getLocoPower();
			Object[] locoParams = view.settingLocomotive(engineType, enginePower);
			
			if(locoParams != null){
				String locoType = locoParams[2].toString() + 
						locoParams[1].toString().substring(0,1);
				Integer grsWeight = (Integer)locoParams[0];

				try {
					model.addLocomotive( grsWeight, locoType);
					view.updateDriverInfo(model.getDriverInfo());
					
					addImage();
					
				} catch (TrainException e) {
					view.showErrorMessage(e.toString());
				} catch (Exception e){
					view.showErrorMessage(e.toString());
				}
				
			}
			else {
				view.showErrorMessage("Invalid parameter(s)");
			
			}
		}
		
		
		
		

		/**
		 * 
		 * */
		private void settingPassengerCar() {
			Integer[] passengerCarParams = view.settingPassengerCar();
			
			if(passengerCarParams != null){
				Integer grossWeight = passengerCarParams[0];
				Integer numberOfSeats = passengerCarParams[1];
				
				try{
					model.addPassengerCar(grossWeight, numberOfSeats);
					view.updateDriverInfo(model.getDriverInfo());
					
					view.updateConductorInfo(model.getConductorInfo());
					addImage();
				} catch (TrainException e){
					view.showErrorMessage(e.toString());
				}
			}
			else {
				view.showErrorMessage("Invalid parameter(s)");
			}
		}

		/**
		 * 
		 * */
		private void settingFreightCar() {
			String[] goodsTypeToChoice = model.getFreightCarGoodsType();
			Object[] freightCarParams = view.settingFreightCar(goodsTypeToChoice);
			
			if(freightCarParams != null){
				Integer grossWeight = (Integer)freightCarParams[0];
				String goodsType = (String)freightCarParams[1];
				String goodsTypeToInput = goodsType.substring(0, 1); 
				
				try{
					model.addFreightCar(grossWeight, goodsTypeToInput);
					view.updateDriverInfo(model.getDriverInfo());
					addImage();
				} catch (TrainException e){
					view.showErrorMessage(e.toString());
				}
			}
			else {
				
				view.showErrorMessage("Invalid parameter(s)");
			}
		}

	}

	

	public void addImage() {
		view.addCarriageImage(model.getLastCarriageString(), model.getLastCarriageType());
		view.updateDriverInfo("Testing3");
	}

	public void checkTrainCanMove() {
		if(!model.trainCanMove()){
			view.showErrorMessage("Warning!!! Train cannot move");
		}
		
	}

	/**
	 * 
	 * */
	public void boardPsg() {
		Integer passengers = view.addPassengers();
		Integer numUnableToBoard = 0;
		
		try{
			numUnableToBoard = model.board(passengers);
		} catch(TrainException e){
			view.showErrorMessage(e.toString());
		}
		
		if(numUnableToBoard > 0){
			String psgCannotBoarding = "Overloaded !!! " + numUnableToBoard + 
					" people cannot board " + newline;
			view.showErrorMessage(psgCannotBoarding);
			view.updateConductorInfo(psgCannotBoarding);
			
		}
		view.updateConductorInfo(model.getConductorInfo());
		view.setNumOnBoard(model.getNumberOnBoard());
	}

}
