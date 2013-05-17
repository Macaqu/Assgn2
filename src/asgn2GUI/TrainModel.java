package asgn2GUI;

import java.util.Observable;
import asgn2Train.DepartingTrain;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;


public class TrainModel extends Observable {

	private DepartingTrain train;
	
	
	
	public TrainModel() {
		train = new DepartingTrain();
		
	}
	
	public void setLocoPower(){
		
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
	
	public void addFreightCar(Integer grossWeight, String goodsType) throws TrainException{
		RollingStock freightCar = new FreightCar(grossWeight, goodsType);
		train.addCarriage(freightCar);
		setChanged();
		notifyObservers();
	}
	
	public void removeCarriage(){
		train.removeCarriage();
		setChanged();
		notifyObservers();
	}
	
	public void board(Integer passenger) throws TrainException{
		train.board(passenger);
		setChanged();
		notifyObservers();
	}
	
	public Integer getNumberOfSeats(){
		return train.numberOfSeats();
	}
	
	public Integer getNumberOnBoard(){
		return train.numberOnBoard();
	}
	
	public Integer getAvailableSeats(){
		return train.numberOfSeats() - train.numberOnBoard();
	}
	
	public String getFirstTrainName(){
		String trainName = null;
		
		RollingStock loco = train.firstCarriage();
		if(loco instanceof Locomotive){
			trainName = loco.toString();
		}
		return trainName;
	}
	
	public String getNextTrainName(){
		String trainName = null;
		
		RollingStock carriage = train.nextCarriage();
		if(carriage != null){
			trainName = carriage.toString();
		}
		return trainName;
	}

}
