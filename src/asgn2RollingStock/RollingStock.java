package asgn2RollingStock;

import asgn2Exceptions.TrainException;

/**
 * Rolling stock are the individual carriages from which a train is constructed. 
 * This abstract class defines characteristics which they all share, most notably having a known gross weight, 
 * measured here in tonnes. (There are, of course many other important shared characteristics of railway carriages,
 * such as identifying codes, a certain number of wheels, the track gauge they're designed for,
 *  etc, but we don't need these for this assignment.) 
 * */
public abstract class RollingStock {

	private Integer grossWeight; //in tonnes
	
	/**
	 * Constructs a railway carriage with a specific gross weight (i.e., the carriage's weight when fully laden). 
	 * 
	 * @param : TrainException - if the gross weight is not positive
	 * */
	public RollingStock(Integer grossWeight) throws TrainException {
		final int MIN_VALID_PARAMS_INTEGER = 0;
		
		if(grossWeight < MIN_VALID_PARAMS_INTEGER){
			throw new TrainException("Gross weight cannot be negative");
		}
		
		this.grossWeight = grossWeight;
	}

	/**
	 * Returns the railway carriage's gross weight.
	 * */
	public Integer getGrossWeight() {
		return this.grossWeight;
	}

	
	/**
	 * Returns a human-readable description of this railway carriage.
	 * */
	@Override
	public String toString(){
		return "";
	}
	

}
