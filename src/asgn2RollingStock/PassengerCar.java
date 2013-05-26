package asgn2RollingStock;

import asgn2Exceptions.TrainException;

/**
 * A passenger car is designed to carry people and has a fixed seating capacity. 
 * We assume that the train is a long-distance one in which all passengers are assigned a seat (unlike your peak-hour, metropolitan commuting experience!).
 * 
 * 
 * @author Lalu Fahany Yazikri
 * */
public class PassengerCar extends RollingStock {

	private Integer numberOfSeats;
	
	private Integer numberOnBoard;
	
	private final int MIN_VALID_PARAMS_INTEGER = 0;
	
	/**
	 * Constructs a passenger car with a known weight and a fixed number of seats. (We allow a passenger car to have zero seats, 
	 * although it would not be very useful.)
	 * @param grossWeight -  the carriage's gross weight in tonnes (ignoring the weight of passengers, which we treat as negligible)
	 * @param numberOfSeats - how many seats are available in the carriage
	 * @throws TrainException - if the gross weight is not positive or if the number of seats is negative
	 */
	public PassengerCar(Integer grossWeight, Integer numberOfSeats) throws TrainException {
		super(grossWeight);
		
		this.numberOnBoard = 0;
		
		if(numberOfSeats < MIN_VALID_PARAMS_INTEGER){
			throw new TrainException("number of seats cannot be negative");
		}
		else {
			this.numberOfSeats = numberOfSeats;
		}
		
	}

	/**
	 * Adds the given number of new passengers to the number on board the carriage. If there are too many new passengers for 
	 * the number of spare seats the left over people are not boarded.
	 * @param  newPassengers - the number of people who wish to board the carriage
	 * @return  the number of people who were unable to board the carriage because they couldn't get a seat
	 * @throws  TrainException - if the number of new passengers is negative
	 * */
	public Integer board(Integer newPassengers) throws TrainException {
		
		if(newPassengers < MIN_VALID_PARAMS_INTEGER){
			throw new TrainException("Passenger cannot negative");
		} 
		
		if(isSpaceOnBoardAvailable(newPassengers)){
			this.numberOnBoard += newPassengers;
			return 0; //no passenger is refused
		} 
		else {
			return newPassengers + this.numberOnBoard - this.numberOfSeats;
		}
	}
	
	/*Return true if space on board available*/
	private boolean isSpaceOnBoardAvailable(Integer newPassengers){
		
		return newPassengers + this.numberOnBoard <= this.numberOfSeats;
	}

	/**
	 * Returns the number of passengers currently on board this carriage.
	 * @return : the number of passengers on board
	 * */
	public Integer numberOnBoard() {
		return this.numberOnBoard;
	}

	/**
	 * Returns the number of seats installed on this carriage
	 * @return : the number of seats on this carriage
	 * */
	public Integer numberOfSeats() {
		return this.numberOfSeats;
	}

	/**
	 * Removes the given number of passengers from this carriage. Attempting to remove more passengers than are on board is not allowed
	 * @param : departingPassengers - the number of passengers alighting from the carriage
	 * @throws :  TrainException - if the number of departing passengers is negative or if the number of departing passengers exceeds the number on board
	 * */
	public void alight(Integer departingPassengers) throws TrainException {
		
		if(departingPassengers < MIN_VALID_PARAMS_INTEGER){ //if parameter negative
			throw new TrainException("failed - the number of departing passengers cannot negative");
		}
		
		if(departingPassengers > this.numberOnBoard){ 
			throw new TrainException("failed - the number of departing passengers" +
					" cannot exceed the number on board");
		}
		
		numberOnBoard -= departingPassengers;
		
	}
	
	
	/**
	 * Returns a human-readable description of the passenger car. 
	 * This has the form "Passenger(x/y)" where x is the number of passengers currently on board 
	 * and y is the number of seats in the carriage.
	 * @return : a human-readable description of the passenger car
	 * */
	public String toString(){
		
		return "Passenger(" + numberOnBoard.toString() + "/" + numberOfSeats.toString() + ")";
	}

}
