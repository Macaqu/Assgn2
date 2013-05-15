package asgn2Train;

import java.util.ArrayList;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;


/**
 * A train is a sequence of carriages. This class defines various operations that can be performed to prepare a long-distance train for departure.
 *
 * We assume that a train can be assembled from any available rolling stock, including locomotives, passenger cars and freight cars. However, they may be configured in only a certain sequence:
 *
 * The first carriage must be a locomotive (and there can be only one locomotive per train).
 * This may be followed by zero or more passenger cars.
 * These may be followed by zero or more freight cars.
 * Any other configurations of rolling stock are disallowed.
 *
 * The process of preparing the train for departure occurs in two stages:
 *
 * The train is assembled from individual carriages. New carriages may be added to the rear of the train only. (Similarly, carriages may be removed from the rear of the train only.)
 * Passengers board the train. For safety reasons, no carriage shunting operations may be performed when any passengers are on board the train.
 * 
 * */
public class DepartingTrain extends Object {

	
	ArrayList<RollingStock> train;
	
	private Integer nextCarriageNumber;
	
	private Integer numberOfSeats;
	
	private Integer grossWeight; //in tonnes
	
	/**
	 * Constructs a (potential) train object containing no carriages (yet).
	 * */
	public DepartingTrain(){
		train = new ArrayList<RollingStock>();
		nextCarriageNumber = 1;
		numberOfSeats = 0;
		grossWeight = 0;
	}
	
	/**
	 * Adds a new carriage to the end of the train. However, a new carriage may be added only if the resulting train configuration is valid, 
	 * as per the rules listed above. Furthermore, shunting operations may not be performed if there are passengers on the train.
	 * Hint: You may find Java's in-built instanceof operator useful when implementing this method (and others in this class).
	 * 
	 * @param : newCarriage - the new carriage to be added
	 * 
	 * @throws : TrainException - if adding the new carriage would produce an invalid train configuration, or if there are passengers on the train
	 *
	 * */
	public void addCarriage(RollingStock newCarriage) throws TrainException {
		
		if(!isConfigurationRight(newCarriage)){
			throw new TrainException("Disallow configuration");
		}
		
		if(isThereAnyPassengerOnBoard()){
			throw new TrainException("There are passengers in the train");
		}
	
		tryToAddNewCarriage(newCarriage);
		
	}

	
	private void tryToAddNewCarriage(RollingStock newCarriage){
		train.add(newCarriage);
		
		if(isAddingCarNotSuccesful()){
			removeCarriage();
		}
		else {
			addNumberOfSeats(newCarriage);
			addGrossWeight(newCarriage);
		}
	}
	
	private void addGrossWeight(RollingStock newCarriage){
		grossWeight += newCarriage.getGrossWeight();
	}
	
	private void addNumberOfSeats(RollingStock newCarriage){
		
		if(newCarriage instanceof PassengerCar){
			numberOfSeats += ((PassengerCar) newCarriage).numberOfSeats();
		}
		
	}
	
	private boolean isAddingCarNotSuccesful(){
		return train.size() > 0 && !trainCanMove();
	}
	
	
	private boolean isThereAnyPassengerOnBoard(){
		return train.size() > 0 && numberOnBoard() != 0;
	}
	
	private boolean isConfigurationRight(RollingStock newCarriage){
		if(newCarriage instanceof PassengerCar){
			return !isPreviousCarNull() && (isPreviousCarLoco()|| isPreviousCarPassengerCar());
		
		} else if(newCarriage instanceof FreightCar){
			return !isPreviousCarNull() && (isPreviousCarPassengerCar() || isPreviousCarFreightCar() 
					|| isPreviousCarLoco());
		
		} else {
			return isPreviousCarNull();
		}
		
	}
	
	private boolean isPreviousCarNull(){
		return train.size() == 0;
	}
	
	private boolean isPreviousCarPassengerCar(){
		return (train.get(train.size()-1) instanceof PassengerCar);
	}
	
	private boolean isPreviousCarLoco(){
		return (train.get(train.size()-1) instanceof Locomotive);
	}
	
	private boolean isPreviousCarFreightCar(){
		return (train.get(train.size()-1) instanceof FreightCar);
	}
	
	
	public boolean trainCanMove() {
		Locomotive locomotive = (Locomotive)train.get(0);
		
		return (locomotive.power() > grossWeight);
	}

	/**
	 * Removes the last carriage from the train. (This may be the locomotive if it is the only item of rolling stock on the train.) 
	 * However, shunting operations may not be performed if there are passengers on the train.
	 * 
	 *  @throws : TrainException - if there is no rolling stock on the "train", or if there are passengers on the train.
	 * */
	public void removeCarriage() {
		if(train.size()>1){
			train.remove(train.size()-1);
		}
	}

	
	/**
	 * Returns the next carriage in the train after the one returned by the immediately preceding call to either this method or method firstCarriage. Special value null is returned 
	 * if there is no such carriage. If there has been no preceding call to either firstCarriage or nextCarriage, this method behaves like firstCarriage, i.e., it returns the first carriage in the train, if any.
	 * NB: When combined with method firstCarriage, this method gives us a simple ability to iteratively examine each of the train's carriages.
	 * 
	 * @return : the train's next carriage after the one returned by the immediately preceding call to either firstCarriage or nextCarriage, or null if there is no such carriage
	 * */
	public RollingStock nextCarriage() {
		RollingStock nextCarriage = null;
		
		if(canNextCarriageGetted()){
			nextCarriage = train.get(nextCarriageNumber);
		}
		
		int maxCarriageNumber = train.size()-1;
		if(this.nextCarriageNumber < maxCarriageNumber){
			this.nextCarriageNumber++;
		}
		
		return nextCarriage;
	}

	
	private boolean canNextCarriageGetted(){
		return this.nextCarriageNumber < train.size();
	}
	
	/**
	 * Returns the total number of passengers currently on the train, counting all passenger cars.
	 * 
	 * @return : the number of passengers on the train
	 * */
	public Integer numberOnBoard() {
		Integer numberOnBoard = 0;
		
		for(int i = 1; i < train.size(); i++){
			if(train.get(i) instanceof PassengerCar){
				numberOnBoard += ((PassengerCar)train.get(i)).numberOnBoard();
			}
		}
		
		return numberOnBoard;
	}

	
	/**
	 * Adds the given number of people to passenger carriages on the train. 
	 * We do not specify where the passengers must sit, so they can be allocated to any vacant seat in any passenger car.
	 * 
	 * @param : newPassengers - the number of people wish to board the train
	 * @return : the number of people who were unable to board the train because they couldn't get a seat
	 * @throws : TrainException - if the number of new passengers is negative
	 * */
	public Integer board(Integer newPassengers) throws TrainException {
		if(newPassengers < 0 ){
			throw new TrainException("new passenger cannot be negative");
		}
		else if(this.numberOnBoard() + newPassengers <= this.numberOfSeats){
			for(int i = 1; i < train.size(); i++){
				if(train.get(i) instanceof PassengerCar){
					newPassengers = ((PassengerCar)train.get(i)).board(newPassengers);
				}
				if(newPassengers == 0){
					break;
				}
			}
			return 0;
		}
		else{
			return this.numberOnBoard() + newPassengers - this.numberOfSeats;
		}
	}

	/**
	 * Returns the first carriage on the train (which must be a locomotive). 
	 * Special value null is returned if there are no carriages on the train at all.
	 *
	 * NB: When combined with method nextCarriage, this method gives us a simple ability to iteratively examine each of the train's carriages.
	 * 
	 * @return : the first carriage in the train, or null if there are no carriages
	 * */
	public RollingStock firstCarriage() {
		if(train.size() > 0){
			return train.get(0);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the total number of seats on the train (whether occupied or not), counting all passenger cars.
	 * 
	 * @return : the number of seats on the train
	 * */
	public Integer numberOfSeats() {
		
		return this.numberOfSeats;
	}

	/**
	 * Returns a human-readable description of the entire train. This has the form of a hyphen-separated list of carriages, 
	 * starting with the locomotive on the left. The description is thus a string "a-b-...-z", 
	 * where a is the human-readable description of the first carriage (the locomotive), b is the description of the second carriage, etc, until the description of the last carriage z. 
	 * (Note that there should be no hyphen after the last carriage.) For example, a possible train description may be "Loco(6D)-Passenger(13/24)-Passenger(16/16)-Freight(G)".
	 *
	 * In the degenerate case of a "train" with no carriages, the empty string is returned.
	 * @return : a human-readable description of the entire train
	 * */
	@Override
	public String toString(){
		String trainString = "";
		
		for(int i = 0; i < train.size(); i++){
			trainString += train.get(i).toString();
			if(i != train.size()-1){
				trainString += "-";
			}
		}
		return trainString;
	}

	
}
