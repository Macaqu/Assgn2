package asgn2GUI;

import java.util.Observable;
import asgn2Train.DepartingTrain;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;

	
/**
 * @author Lalu Fahany Yazikri
 * 
 * */
public class TrainModel  {
	
	
	private static DepartingTrain train;
	
	public enum CarriageTypes{Locomotive, PassengerCar, FreightCar};
	
	
	public TrainModel() {
		train = new DepartingTrain();

	}
	
	public void newTrain(){
		train = new DepartingTrain();
	}
	
	public boolean isContainPassengersCar(){
		RollingStock carriage = train.firstCarriage();
		int numPsgCar = 0;
		while(carriage != null){
			if(carriage instanceof Locomotive){
				numPsgCar++;
			}
		}
		return numPsgCar > 0;
	}
	
	private static String getCarriageName(CarriageTypes car){
		String carName = "";
		
		switch(car){
			case Locomotive 	: carName += "Locomotive"; break;
			case PassengerCar 	: carName += "Passenger Car"; break;
			case FreightCar		: carName += "Freight Car"; break;
		}
		
		return carName;
	}
	
	
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
	
	private String newline = "\n";
	
	/**
	 * Return a string for driver information 
	 * */
	public String getDriverInfo(){
		double grossWeight = getGrossWeight();
		String info = "====== INFO FOR DRIVER =====" + newline + newline;
		info += "train configuration = " + getConfigurationName() + newline;
		info += "total power = " + getPower().toString() + newline;
		info += "total weight = " + grossWeight + " tonnes" + newline; 
		info += " ------------------------------------ -" + newline;
		
		double allowedAddWeight = getPower() - grossWeight;
		if(allowedAddWeight < 0){
			info += "WARNING!!! OVERLOADED - CANNOT MOVE" + allowedAddWeight 
					+ " tonnes" + newline;
		}
		else {
			info += "allowed additional grossweight = " + allowedAddWeight + 
					" tonnes" + newline;
		}
		
		Integer numOnBoard = getNumberOnBoard(); 
		if(numOnBoard != 0){
			info += "WARNING !!! adding a carriage is not allowed because there are" +
					"passenger on board" + " (" + numOnBoard.toString() + " people)" + 
					newline;
		}
		
		info += "===============" + newline;
		return info;
	}
	
	public boolean trainCanMove(){
		return train.trainCanMove();
	}
	
	public String getLastCarriageString(){
		RollingStock carriage = getLastCarriage();
		return carriage.toString();
	}
	
	public CarriageTypes getLastCarriageType(){
		RollingStock carriage = getLastCarriage();
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
	 * Return a string for conductor's information
	 * */
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
	
	public String[] getCarriageType(){
		String[] carriageToChoose = null; 
		RollingStock lastCarriage = getLastCarriage();
		if(lastCarriage == null){
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
		
	
	public String[] getLocoEngineType(){
		String[] powerToChoose = new String[] 
				{"E - Electric", "D - Diesel", "S - Stream"};
		return powerToChoose;
	}
	
	public String[] getLocoPower(){
		String[] locoPower = new String[9];
		for(int i = 0; i< locoPower.length; i++){
			locoPower[i] = Integer.toString(i+1);
		}
		return locoPower;
	}
	
	public RollingStock getLastCarriage(){
		RollingStock currentCarriage = train.firstCarriage();
		RollingStock lastCarriage = null;
		while(currentCarriage != null){
			lastCarriage = currentCarriage;
			currentCarriage = train.nextCarriage();
		}
		return lastCarriage;
	}
	
	public void addLocomotive(Integer grossWeight, String classification) throws TrainException{
		RollingStock locomotive = new Locomotive(grossWeight, classification);
		train.addCarriage(locomotive);
		//setChanged();
		//notifyObservers();
	}
	
	public void addPassengerCar(Integer grossWeight, Integer numberOfSeats) throws TrainException{
		RollingStock passengerCar = new PassengerCar(grossWeight, numberOfSeats);
		train.addCarriage(passengerCar);
		//setChanged();
		//notifyObservers();
	}
	
	
	
	public void addFreightCar(Integer grossWeight, String goodsType) throws TrainException{
		RollingStock freightCar = new FreightCar(grossWeight, goodsType);
		train.addCarriage(freightCar);
		//setChanged();
		//notifyObservers(new String("add Freight Car"));
	}
	
	public String[] getFreightCarGoodsType(){
		String[] goodsTYpeToChoose = new String[]{"G - General Goods",
				"R - Refrigerated Goods", "D - Dangerous materials"};
		return goodsTYpeToChoose;
	}
	
	
	public String getConfigurationName(){
		return train.toString();
	}
	
	public void removeCarriage() throws TrainException{
		train.removeCarriage();
		//setChanged();
		//notifyObservers();
	}
	
	public Integer board(Integer passenger) throws TrainException{
		Integer psgNotDepart = train.board(passenger);
		//setChanged();
		//notifyObservers();
		return psgNotDepart;
	}
	
	public Integer getNumberOfSeats(){
		return train.numberOfSeats();
	}
	
	public Integer getPower(){
		try{
			return ((Locomotive)train.firstCarriage()).power();
		} catch (NullPointerException e){
			return 0;
		}
	}
	
	public Integer getNumberOnBoard(){
		return train.numberOnBoard();
	}
	
	public Integer getAvailableSeats(){
		return train.numberOfSeats() - train.numberOnBoard();
	}
	
	public String getCarriageName(RollingStock carriage){
		String trainName = null;
		
		if(carriage != null)
			trainName = carriage.toString();
		
		return trainName;
	}
	

}
