package asgn2GUI;

import java.util.ArrayList;

import asgn2Train.DepartingTrain;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;

	
/**
 * @author Lalu Fahany Yazikri
 * 
 * */
public class TrainModel  {
	
	
	private static DepartingTrain train;
	
	private String newline = "\n";
	
	public enum CarriageTypes{Locomotive, PassengerCar, FreightCar};
	
	
	/**
	 * Nullable constructor. Create a method for creating an instance of DepartingTrain();
	 */
	public TrainModel() {
		newTrain();

	}
	
	
	/**
	 * creating an instance of DepartingTrain();
	 */
	public void newTrain(){
		train = new DepartingTrain();
	}
	
	
	/**
	 * 
	 * @param CarriageTypes carriage : 
	 * 
	 * @return String
	 */
	private static String getCarriageName(CarriageTypes carriage){
		String carName = "";
		
		switch(carriage){
			case Locomotive 	: carName += "Locomotive"; break;
			case PassengerCar 	: carName += "Passenger Car"; break;
			case FreightCar		: carName += "Freight Car"; break;
		}
		
		return carName;
	}
	
	
	/**
	 * 
	 * @return double
	 */
	public double getGrossWeight(){
		double grossWeight = 0;
		RollingStock carriage = train.firstCarriage();
		
		if(carriage != null){
			grossWeight += carriage.getGrossWeight();
		}
		
		while(carriage != null){
			carriage = train.nextCarriage();
			if(carriage == null){
				break;
			}
			grossWeight += carriage.getGrossWeight();
		}
		
		return grossWeight;
	}
	
	
	/**
	 * String factory for the driver info
	 * 
	 * @return a string for driver information 
	 */
	public String getDriverInfo(){
		double grossWeight = getGrossWeight();
		String info = "====== INFO FOR DRIVER =====" + newline + newline;
		info += "Train configuration = " + getConfigurationName() + newline;
		info += "Total power = " + getPower().toString() + newline;
		info += "Total weight = " + grossWeight + " tonnes" + newline; 
		info += " ------------------------------------ -" + newline;
		
		double allowedAddWeight = getPower() - grossWeight;
		if(allowedAddWeight > 0){
			info += "Allowed additional grossweight = " + allowedAddWeight + 
					" tonnes" + newline;
		}
		
		if(train.numberOnBoard()!= 0){
			info += "ATTENTION !!! NO ALLOWED ADDING/REMOVE CARRIAGE(S) - due to " +
					train.numberOnBoard().toString() + "passenger on board" + 
					newline;
			info += "(safety first)";
		}
		
		info += "===============" + newline;
		return info;
	}
	
	
	public String getDriverWarning(){
		String warning = "";
		if(!train.trainCanMove()){
			warning += "WARNING!!! OVERLOADED - CANNOT MOVE. Exceed " 
					+ (double)(getPower() - getGrossWeight())
					+ " tonnes" + newline;
			warning += "(Please remove carriage(s) until the color become blue)" + newline;
			warning += "------------------------" + newline;
		}
		
		return warning;
	}
	
	/**
	 * Call boolean trainCanMove in the train instance
	 * 
	 * @return boolean
	 */
	public boolean trainCanMove(){
		return train.trainCanMove();
	}
	
	
	public ArrayList<CarriageImage> getCarriageImage(){
		ArrayList<CarriageImage> carriageImageList = new ArrayList<CarriageImage>();
		
		//inisiate
		RollingStock carriage = train.firstCarriage();
		if(carriage != null){
			carriageImageList.add(new CarriageImage(carriage.toString(), CarriageTypes.Locomotive));
		}
		
		while(carriage != null){
			carriage = train.nextCarriage();
			if(carriage == null){
				break;
			}
			carriageImageList.add(new CarriageImage(carriage.toString(), getTypeOf(carriage)));
		}
		
		return carriageImageList;
	}
	
	
	/**
	 * 
	 * @return String: the representation of the last carriage 
	 */
	public String getLastCarriageString(){
		RollingStock carriage = getLastCarriage();
		return carriage.toString();
	}
	
	
	/**
	 * 
 	 * @return CarriageTypes: the type of the last carriage in this train
	 */
	public CarriageTypes getLastCarriageType(){
		RollingStock carriage = getLastCarriage();

		return getTypeOf(carriage);
	}
	
	
	public CarriageTypes getTypeOf(RollingStock carriage){
		CarriageTypes type = null;
		
		if(carriage instanceof Locomotive){
			type = CarriageTypes.Locomotive;
		} 
		else if(carriage instanceof FreightCar){
			type = CarriageTypes.FreightCar;
		}
		if(carriage instanceof PassengerCar){
			type = CarriageTypes.PassengerCar;
		}
		return type;
	}
	
	/**
	 * string factory to produce the information for conductor
	 * 
	 * @return a String for conductor's information
	 */
	public String getConductorInfo(){
		String info = "=========== INFO FOR CONDUCTOR ======" + newline 
				+ newline;
		
		info += "Total Number of Seats = " + 
				getNumberOfSeats().toString() + newline;
		info += "Total Passengers = " + getNumberOnBoard().toString() + newline;
		
		Integer allowedAddPass = getNumberOfSeats() - getNumberOnBoard();
		info += "Allowed additional passengers = " + allowedAddPass.toString() + 
				" people" + newline;
		info += "=============" + newline;
		return info;
	}
	
	
	/**
	 * 
	 * @return String[] : the carriage type for choosen by user
	 */
	public String[] getCarriageType(){
		String[] carriageToChoose = null; 
		RollingStock lastCarriage = getLastCarriage();
		
		if(lastCarriage == null){ //no carriage in the train
			carriageToChoose = new String[]{getCarriageName(CarriageTypes.Locomotive)};
		}
		else{
			if( lastCarriage instanceof FreightCar){
				carriageToChoose = new String[]{getCarriageName(CarriageTypes.FreightCar)};
			}
			else{
				carriageToChoose = new String[]{getCarriageName(CarriageTypes.PassengerCar),
						getCarriageName(CarriageTypes.FreightCar)};
			}
			
		}
		return carriageToChoose;
	}
		
	
	/**
	 * 
	 * @return String[]: Engine types for choosen by user
	 */
	public String[] getLocoEngineType(){
		String[] engineTypes = new String[] 
				{"E - Electric", "D - Diesel", "S - Stream"};
		return engineTypes;
	}
	
	
	/**
	 * 
	 * @return String[] : a string array that contain power class
	 */
	public String[] getLocoPowerClass(){
		final int NUM_POWER_CLASS = 9;
		String[] locoPowerClass = new String[NUM_POWER_CLASS];
		for(int i = 0; i< locoPowerClass.length; i++){
			locoPowerClass[i] = Integer.toString(i+1);
		}
		return locoPowerClass;
	}
	
	
	/**
	 * 
	 * @return RollingStock : the last carriage in type RollingStock
	 */
	public RollingStock getLastCarriage(){
		RollingStock currentCarriage = train.firstCarriage();
		RollingStock lastCarriage = null;
		
		while(currentCarriage != null){
			lastCarriage = currentCarriage;
			currentCarriage = train.nextCarriage();
		}
		
		return lastCarriage;
	}
	
	
	/**
	 * Add locomotive in this train
	 * @param Integer grossWeight 
	 * @param String classification
	 * @throws TrainException if one or more the supplied parameters is invalid
	 */
	public void addLocomotive(Integer grossWeight, String classification) throws TrainException{
		RollingStock locomotive = new Locomotive(grossWeight, classification);
		train.addCarriage(locomotive);
	}
	
	
	/**
	 * 
	 * @param Integer grossWeight
	 * @param Integer numberOfSeats
	 * @throws TrainException if one or more the supplied parameters is invalid
	 */
	public void addPassengerCar(Integer grossWeight, Integer numberOfSeats) throws TrainException{
		RollingStock passengerCar = new PassengerCar(grossWeight, numberOfSeats);
		train.addCarriage(passengerCar);
	}
	
	
	/**
	 * 
	 * @param Integer grossWeight
	 * @param String goodsType
	 * @throws TrainException if one or more the supplied parameters is invalid
	 */
	public void addFreightCar(Integer grossWeight, String goodsType) throws TrainException{
		RollingStock freightCar = new FreightCar(grossWeight, goodsType);
		train.addCarriage(freightCar);
	}
	
	
	/**
	 * 
	 *  @return String[] the string array of goods type for choosen by users
	 */
	public String[] getFreightCarGoodsType(){
		String[] goodsTypeToChoose = new String[]{"G - General Goods",
				"R - Refrigerated Goods", "D - Dangerous materials"};
		return goodsTypeToChoose;
	}
	
	
	/**
	 * 
	 * @return a String represtation of the train 
	 */
	public String getConfigurationName(){
		return train.toString();
	}
	
	
	/**
	 * 
	 * @throws TrainException
	 */
	public void removeCarriage() throws TrainException{
		train.removeCarriage();
	
	}
	
	
	/**
	 * 
	 * 
	 * @param Integer passenger
	 * @return Integer : the number of passengers that refused to board
	 * @throws TrainException if the supplied parameter is invalid
	 */
	public Integer board(Integer passenger) throws TrainException{
		Integer psgNotDepart = train.board(passenger);
		return psgNotDepart;
	
	}
	
	
	/**
	 * 
	 * @return the number of seats in this train in the Integer data type
	 */
	public Integer getNumberOfSeats(){
		return train.numberOfSeats();
	}
	
	
	/**
	 * 
	 * @return the locomotive power in Integer data type 
	 */
	public Integer getPower(){
		try{
			return ((Locomotive)train.firstCarriage()).power();
		} catch (NullPointerException e){
			return 0;
		}
	}
	
	
	/**
	 * 
	 * @return the number of passengers on board in the Integer data type
	 */
	public Integer getNumberOnBoard(){
		return train.numberOnBoard();
	}
	
	
	/**
	 * 
	 * @return the number of available seats in this train in the Integer data type
	 */
	public Integer getAvailableSeats(){
		return train.numberOfSeats() - train.numberOnBoard();
	}
	
	
	/**
	 * 
	 * @param RollingStock carriage
	 * 
	 * @return the name of each carriage in the String data type
	 */
	public String getCarriageName(RollingStock carriage){
		String trainName = null;
		
		if(carriage != null)
			trainName = carriage.toString();
		
		return trainName;
	}

}
