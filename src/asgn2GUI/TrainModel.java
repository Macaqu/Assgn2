package asgn2GUI;

import java.util.Observable;
import asgn2Train.DepartingTrain;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;

	
public class TrainModel extends Observable {

	private static DepartingTrain train;
	
	public enum CarriageTypes{Locomotive, PassengerCar, FreightCar};
	
	public TrainModel() {
		train = new DepartingTrain();

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
	
	public String[] getCarriageType(){
		String[] carriageToChoose = null; 
		RollingStock firstCar = train.firstCarriage();
		RollingStock nextCar = train.nextCarriage();
		if(firstCar == null){
			carriageToChoose = new String[]{getCarriageName(CarriageTypes.Locomotive)};
		}
		else{
			if( nextCar instanceof FreightCar){
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
	
	public void addLocomotive(Integer grossWeight, String classification) throws TrainException{
		RollingStock locomotive = new Locomotive(grossWeight, classification);
		train.addCarriage(locomotive);
		setChanged();
		notifyObservers();
	}
	
	public void addPassengerCar(Integer grossWeight, Integer numberOfSeats) throws TrainException{
		RollingStock passengerCar = new PassengerCar(grossWeight, numberOfSeats);
		train.addCarriage(passengerCar);
		setChanged();
		notifyObservers();
	}
	
	public String[] getFreightCarGoodsType(){
		String[] goodsTYpeToChoose = new String[]{"G - General Goods",
				"R - Refrigerated Goods", "D - Dangerous materials"};
		return goodsTYpeToChoose;
	}
	
	public void addFreightCar(Integer grossWeight, String goodsType) throws TrainException{
		RollingStock freightCar = new FreightCar(grossWeight, goodsType);
		train.addCarriage(freightCar);
		setChanged();
		notifyObservers();
	}
	
	public String getConfigurationName(){
		return train.toString();
	}
	
	public void removeCarriage() throws TrainException{
		train.removeCarriage();
		setChanged();
		notifyObservers();
	}
	
	public Integer board(Integer passenger) throws TrainException{
		Integer psgNotDepart = train.board(passenger);
		setChanged();
		notifyObservers();
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
