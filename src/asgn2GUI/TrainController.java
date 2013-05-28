package asgn2GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import asgn2Exceptions.TrainException;

/**
 * This class has a role as the Controller for TrainGUI(the view) and TrainModel(the model)
 * Within this class train model, which is corresponded with departing train class, is created an object
 * @author Lalu Fahany Yazikri
 * @author Yudo Dwi Hanggodo Patriabekti
 * */

public class TrainController{

	private TrainModel model;
	
	private TrainGUI view;
	
	private Color driverInfoColor;
	
	private Color conductorInfoColor;
	
	private Color warningColor;
	
	private String newline = "\n";
	
	/**
	 * Constructor that taken 2 arguments
	 * 
	 * @param TrainModel model
	 * @param TrainGUI gui
	 * */
	public TrainController(TrainModel model, TrainGUI gui) {
		this.model = model;
		this.view = gui;
		setColor();
		gui.addActionListener(new TrainListener());
		
	}
	
	private void setColor() {
		driverInfoColor = Color.BLUE;
		
		conductorInfoColor = Color.DARK_GRAY;
		
		warningColor = Color.red;
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
			setBoardbtnEnable();
			setRemovebtnEnable();
		}
	}
	
	

	/**
	 * Enable board button if the seats on train are available 
	 * */
	private void setBoardbtnEnable() {
		boolean isEnable = false;
		if( model.getAvailableSeats() != 0){
			isEnable = true;
		}
		view.setBoardbtnEnable(isEnable);
	}

	/**
	 * 
	 * Enable remove button if minimum one carriage exists 
	 */
	private void setRemovebtnEnable(){
		boolean isEnable = false;
		
		if(model.isLocomotiveExist()){
			isEnable = true;
		}
		view.setRemoveCrgBtnEnable(isEnable);
	}
	
	
	/**
	 * Reset the game. Call the newTrain method in the model and the resetGame in the view
	 * */
	private void resetGame() {
		model.newTrain();
		view.resetGame();
	}

	
	/**
	 * Remove the image in the model and the carriage in the view. Call dialog box
	 * for display error when the TrainException is thrown
	 * */
	private void removeCarriage() {
		try{
			boolean needUpdateConductorInfo = false;
			
			if(model.getLastCarriageType() == TrainModel.CarriageTypes.PassengerCar){
				needUpdateConductorInfo = true;
			}
			
			model.removeCarriage();
			
			updateInfo(true, needUpdateConductorInfo);

			updateImage();

		} catch(TrainException e){
		
			view.showErrorMessage(e.toString());
		}
	}

	
	/**
	 * Update info that in textArea
	 * 
	 * @param boolean displayDriverInfo : true if driver info is wanted to be updated
	 * @param boolean displayConductorInfo : true if conductor info is wanted to be updated
	 * */
	private void updateInfo(boolean displayDriverInfo, boolean displayConductorInfo){
		if(displayDriverInfo){
			view.updateInfo(model.getDriverInfo(), view.getDriverDisplay(), driverInfoColor);
			
			String driverWarning = model.getDriverWarning();
			if(!driverWarning.isEmpty()){
				view.updateInfo(driverWarning, view.getDriverDisplay(), warningColor);
		
			}
		}
		
		if(displayConductorInfo){
			view.updateInfo(model.getConductorInfo(), view.getConductorDisplay(), conductorInfoColor);
		}
	}
	
	
	/**
	 * Call the setting of carriage based on the carriage which user choose 
	 * */
	private void addCarriage(){
		String userChoosen = view.chooseCar(model.getCarriageType());
		
		if(userChoosen == null){
			return;
		}
		
		switch(userChoosen){
			case "Locomotive" : settingLocomotive(); break;
			case "Passenger Car" : settingPassengerCar(); break;
			case "Freight Car" : settingFreightCar(); break;
		}
		
	}

	
	/**
	 * Call the option of engineType and enginePower from the model and pass the view.
	 * Receive an array of object and passed to the model in order to generate an engine
	 * */
	private void settingLocomotive() {
		String[] engineType = model.getLocoEngineType();
		String[] enginePower = model.getLocoPowerClass();
		Object[] locoParams = view.settingLocomotive(engineType, enginePower);
		
		if(locoParams == null){
			view.showErrorMessage("Invalid parameter(s)");
			return;
		}
		
		String locoType = locoParams[2].toString() + 
				locoParams[1].toString().substring(0,1);
		
		Integer grsWeight = (Integer)locoParams[0];

		try {
			model.addLocomotive( grsWeight, locoType);
			updateInfo(true, false);
			
			updateImage();
			
		} catch (TrainException e) {
			view.showErrorMessage(e.toString());
		} catch (Exception e){
			view.showErrorMessage(e.toString());
		}
		
	}
	
	
	/**
	 *
	 * Receive an array of Integer that contains gross weight and number of seats 
	 * and passed to the model in order to generate a passenger carriage
	 * */
	private void settingPassengerCar() {
		Integer[] passengerCarParams = view.settingPassengerCar();
		
		if(passengerCarParams == null){
			view.showErrorMessage("Invalid parameter(s)");
			return;
		}
		
		Integer grossWeight = passengerCarParams[0];
		Integer numberOfSeats = passengerCarParams[1];
		
		try{
			model.addPassengerCar(grossWeight, numberOfSeats);
			updateInfo(true, true);
			updateImage();
		} catch (TrainException e){
			view.showErrorMessage(e.toString());
		}
	}

	
	/**
	 * Call the option of engineType and enginePower from the model and pass the view.
	 * Receive an array of object and passed to the model in order to generate an engine
	 * */
	private void settingFreightCar() {
		String[] goodsTypeToChoice = model.getFreightCarGoodsType();
		Object[] freightCarParams = view.settingFreightCar(goodsTypeToChoice);
		
		if(freightCarParams == null){
			view.showErrorMessage("Invalid parameter(s)");
			return;
		}
		
		Integer grossWeight = (Integer)freightCarParams[0];
		String goodsType = (String)freightCarParams[1];
		String goodsTypeToInput = goodsType.substring(0, 1); 
		
		try{
			model.addFreightCar(grossWeight, goodsTypeToInput);
			updateInfo(true, false);
			updateImage();
		} catch (TrainException e){
			view.showErrorMessage(e.toString());
		}
		
	}


	/**
	 * Call the method in the view for adding a carriage image and pass the carriage string and
	 * carriage type from the model
	 * */
	private void updateImage() {
		ArrayList<CarriageImage> imagesList = model.getCarriageImage();
		
		view.updateImage(imagesList);
	}

	 
	
	

	/**
	 * Receive the user's input of boarding passengers in the GUI(view) 
	 * and pass it to the model.
	 * */
	private void boardPsg() {
		Integer passengers = view.addPassengers();
		Integer numUnableToBoard = 0;
		
		try{
			numUnableToBoard = model.board(passengers);
			updateImage();
		} catch(TrainException e){
			view.showErrorMessage(e.toString());
		}
		
		if(numUnableToBoard > 0){
			String psgCannotBoarding = "WARNING!!! Passengers overload - " + numUnableToBoard + 
					" people cannot board " + newline;
			view.showErrorMessage(psgCannotBoarding);
			view.updateInfo(psgCannotBoarding, view.getConductorDisplay(), warningColor);
			
		}
		updateInfo(true, true);

	}

}
