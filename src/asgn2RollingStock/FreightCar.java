package asgn2RollingStock;

import asgn2Exceptions.TrainException;

/**
 * Freight cars are designed to handle a variety of goods. For the purposes of this assignment we assume 
 * there are three freight car types of interest, characterised by the kinds of goods they are designed 
 * to carry:
 *	
 * "G" - General goods
 * "R" - Refrigerated goods
 * "D" - Dangerous materials
 * 
 * @author Lalu Fahany Yazikri
 * */
public class FreightCar extends RollingStock {

	private String goodsType;
	
	/**
	 * Constructs a freight car object.
	 * 
	 * @param: grossWeight - the freight car's gross weight (fully-laden), in tonnes
	 * @param: goodsType - the type of goods the car is designed to carry (either "G", "R" or "D")
	 * @throws: TrainException - if the gross weight is not positive or if the goods' type is invalid
	 * */
	public FreightCar(Integer grossWeight, String goodsType) throws TrainException {
		super(grossWeight);
		
		if(!isValidGoodsType(goodsType)){
			throw new TrainException("Failed - the goods' type is invalid");
		}
		
		this.goodsType = goodsType;
		
	}
	
	/**
	 * Return true if the supplied argument (goodsType) is either "G", "R" or "D" 
	 * 
	 *  @param goodsType - the type of goods the car is designed to carry (either "G", "R" or "D")
	 */
	private boolean isValidGoodsType(String goodsType)
	{
		return (goodsType.equals("G") || goodsType.equals("R")|| goodsType.equals("D")) ; 
	}

	
	/**
	 * Returns the type of goods this carriage was designed to carry.
	 * 
	 * @return  the goodsType (G", "R" or "D")
	 * */
	public String goodsType(){
		
		return this.goodsType;
	}
	
	
	/**
	 *   Returns a human-readable description of the freight car. This has the form "Freight(x)" 
	 *   where x is a character ("G", "R" or "D") indicating the type of goods the car is designed to carry.
	 * 	@return: a human-readable description of the freight car
	 * */
	public String toString(){
		
		return "Freight(" + goodsType + ")";
	}
	
}
