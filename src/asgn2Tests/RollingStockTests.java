package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;

/**
 * Test all classes which is connected to RollingStock abstract class, that are:
 * - FreightCar Class
 * - Locomotive Class
 * - PassangerCar Class
 * 
 * @author Lalu Fahany Yazikri
 * @version May 2013 
 * */
public class RollingStockTests {
 
	/**
	 * Create FreightCar class in asgn2RollingStock that implement RollingStock.
	 * Passing parameter grossWeight and goodsType. Both parameters are in Integer type.
	 * 
	 * note: passing grossWeight to abstract parameter
	 * */
	@Test
	public void testCreateFreightCar() throws TrainException {
		Integer grossWeight = 1;
		String goodsType = "G";
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarUnderTest =  
			new asgn2RollingStock.FreightCar((Integer)grossWeight, (String)goodsType);
		
	}
	
	/**
	 * Test with calling valid good type and invalid gross weight
	 * Check whether TrainException in abstract class can be implemented in FreightCar.class
	 * when calling invalid gross weight
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidGrossWeight() throws TrainException
	{
		String validGoodsType = "G";
		Integer invalidGrossWeight = -1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidGrossWeight = 
				new asgn2RollingStock.FreightCar(invalidGrossWeight , validGoodsType);
	}
	
	/**
	 * Test for FreightCar class with calling invalid good type and valid gross weight.
	 * Create TrainException in FreightCar constructor when invalid good type is supplied.
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidGoodsType() throws TrainException
	{
		String invalidGoodsType = "Z";
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidGoodsType = 
				new asgn2RollingStock.FreightCar(validGrossWeight , invalidGoodsType);
	}
	
	/**
	 * Test for freight car with calling null good type and valid gross weight
	 * 
	 * @exception NullPointerException.class
	 * */
	@Test(expected = NullPointerException.class)
	public void testCreateFreightCarWithInvalidNullGoodsType() throws TrainException
	{
		String invalidNullGoodsType = null;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidNullGoodsType = 
				new asgn2RollingStock.FreightCar(validGrossWeight , invalidNullGoodsType);
	}
	
	/**
	 * Test for FreightCar class with calling invalid good type and invalid gross weight.
	 * Check whether both invalid arguments produce TrainException
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidBothArguments() throws TrainException
	{
		String invalidGoodsType = "K";
		Integer invalidGrossWeight = -9;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidGrossWeight = 
				new asgn2RollingStock.FreightCar(invalidGrossWeight , invalidGoodsType);
	}
	
	/**
	 * Create getGrossWeight() in FreightCar class with Integer data type.
	 * This method is accessor for grossWeight in FreightCar class.
	 * */
	@Test
	public void testGetGrossWeightOfFreightCar() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  
				new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		assertEquals(grossWeight, freightCarUnderTest.getGrossWeight());
	}
	
	/**
	 * Create goodsType() in FreightCar class with String data type.
	 * This method is accessor for goodsType in FreightCar class.
	 * */
	@Test
	public void testGetGoodsTypeOfFreightCar() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  
				new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		assertEquals(goodsType, ((asgn2RollingStock.FreightCar) freightCarUnderTest).goodsType());
	}
	
	/**
	 * Create toString() method in FreightCar class that represent FreightCar
	 * in string.
	 * */
	@Test
	public void testFreightCarToString() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  
				new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		String expectedString = "Freight(G)";
		String actualString = freightCarUnderTest.toString();
		assertEquals(expectedString, actualString);
	}
	
	/*LOCOMOTIVE*/
	
	/**
	 * Create Locomotive class in asgn2RollingStock that implement RollingStock.
	 * Passing parameter grossWeight (Integer) and classification (string). 
	 * 
	 * note: in Locomotive class, passing grossWeight to abstract parameter
	 * */
	@Test
	public void testCreateLocomotive() throws TrainException {
		Integer grossWeight = 1;
		String classification = "9E";
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveUnderTest =  
			new asgn2RollingStock.Locomotive((Integer)grossWeight, (String)classification);
		
	}
	
	
	 /**
	 * Test with calling valid classification and invalid gross weight
	 * Check whether TrainException in abstract class can be implemented in Locomotive.class
	 * when calling invalid gross weight
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidGrossWeight() throws TrainException
	{
		String validClassification = "5E";
		Integer invalidGrossWeight = -1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidGrossWeight = 
				new asgn2RollingStock.Locomotive(invalidGrossWeight , validClassification);
	}
	

	/**
	 * Test for Locomotive class with calling invalid specification and valid gross weight.
	 * Create TrainException in Locomotive constructor when invalid specification is supplied.
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidSpecification() throws TrainException
	{
		String invalidSpecification = "3Z";
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidSpecification = 
				new asgn2RollingStock.Locomotive(validGrossWeight , invalidSpecification);
	}

	/**
	 * Test for Locomotive class with calling invalid specification one digit and valid gross weight.
	 * check whether TrainException in Locomotive constructor is able to handle the supplied of one digit 
	 * invalid specification 
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidOneDigitSpecification() throws TrainException
	{
		String invalidSpecification = "Z";
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidSpecification = 
				new asgn2RollingStock.Locomotive(validGrossWeight , invalidSpecification);
	}

	
	
	/**
	 * Create power() method in Locomotive class with Integer data type
	 * which return the power of locomotive.
	 * Formula of power :
	 * power = 100 x power_classification
	 * power classification can be taken from substring(0,1) of classification parameter 
	 * */
	@Test
	public void testGetLocomotivePower() throws TrainException {
		Integer validGrossWeight = 1;
		String validClassification = "9E";
		final Integer POWER_BASE = 100;
		Integer expectedPower = POWER_BASE * Integer.parseInt(validClassification.substring(0,1));
		
		asgn2RollingStock.RollingStock locomotiveUnderTest =  
			new asgn2RollingStock.Locomotive(validGrossWeight, validClassification);
		
		assertEquals(((asgn2RollingStock.Locomotive)locomotiveUnderTest).power(), expectedPower);
	}
	
	/**
	 * create toString() method in Locomotive class that return a string
	 * representation of Locomotive 
	 * Expected returned string = "Loco("+specification+")"
	 * */
	@Test
	public void testLocomotiveToStringIsOverriden() throws TrainException {
		Integer grossWeight = 1;
		String classification = "9E";
		String expectedString = "Loco(9E)";
		
		asgn2RollingStock.RollingStock locomotiveUnderTest =  
			new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		assertEquals(((asgn2RollingStock.Locomotive)locomotiveUnderTest).toString(), expectedString);
	}
	
	/**
	 * Create getGrossWeight() method in locomotive class with Integer data type
	 * This method is an accessor of gross weight of locomotive class
	 * 
	 * */
	@Test
	public void testLocomotiveGetGrossWeight() throws TrainException {
		Integer validGrossWeight = 1;
		String validClassification = "9E";
		
		asgn2RollingStock.RollingStock locomotiveUnderTest =  
			new asgn2RollingStock.Locomotive(validGrossWeight, validClassification);
		
		assertEquals(((asgn2RollingStock.Locomotive)locomotiveUnderTest).getGrossWeight(), validGrossWeight);
	}
	
	/*PASSENGER CAR*/
	
	/**
	 * Create Passenger class in asgn2RollingStock that implement RollingStock.
	 * Passing parameter grossWeight (Integer) and numberOfSeats (Integer). 
	 * 
	 * note: in Locomotive class, passing grossWeight to abstract parameter
	 * */
	@Test
	public void testCreatePassengerCar() throws TrainException {
		Integer grossWeight = 1;
		Integer numberOfSeats = 1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
	}
	
	/**
	 * Check whether TrainException from abstract class is able to be implemented in 
	 * PassengerCar class. Supplied invalid gross weight in PassengerCar.
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreatePassengerCarWithInvalidGrossWeight() throws TrainException
	{
		Integer validNumberOfSeats = 5;
		Integer invalidGrossWeight = -1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarWithInvalidGrossWeight = 
				new asgn2RollingStock.PassengerCar((Integer)invalidGrossWeight, (Integer)validNumberOfSeats);
	}

	/**
	 * Create TrainException in PassengerCar constructor when invalid negative gross weight is supplied.
	 * 
	 * @exception TrainException.class
	 * */
	@Test(expected = TrainException.class)
	public void testCreatePassengerCarWithInvalidNumberOfSeats() throws TrainException
	{
		Integer invalidNumberOfSeats = -5;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarWithInvalidNumberOfSeats = 
				new asgn2RollingStock.PassengerCar((Integer)validGrossWeight , (Integer)invalidNumberOfSeats);
	}

	
	/**
	 * Create board() method in PassengerCar class which taken a parameter newPassengers in Integer data type.
	 * This method should return the number of passengers in Integer data type 
	 * which do not able to board due to the limited number of seats and return 0 if all passenger can board.
	 * This test would supply newPassenger less than number of seats and expected return 0;
	 * */
	@Test
	public void testPassengersBoardsToPassengerCar() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 5;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		Integer expectedPeopleNotGetSeat = 0;
		Integer peopleNotGetSeat = ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board
				((Integer) newPassengers);
		
		assertEquals("expected = " + expectedPeopleNotGetSeat.toString() + " but " + peopleNotGetSeat.toString(),
				expectedPeopleNotGetSeat, peopleNotGetSeat);
	}
	
	/**
	 * This is continuation of testPassengersBoardsToPassengerCar() above which supply newPassengers
	 * more than numberOfSeats. Expected return numberOfSeats - newPassengers
	 * 
	 * */
	@Test
	public void testPassengerBoardMoreThanNumOfSeats() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 15;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		Integer expectedPeopleNotGetSeat = newPassengers - numberOfSeats;
		Integer peopleNotGetSeat = ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		assertEquals(expectedPeopleNotGetSeat, peopleNotGetSeat);
	}
	
	/**
	 * Check the return of board() method in PassengerCar in the following condition:
	 * - in first board, the PassengerCar taken newPassengers less than numberOfSeats
	 * - in second board, the PassengerCar taken newPassengers again so totally number newPassengers
	 *   more than numberOfSeats
	 *   Expected return = total newPassengers - numberOfSeats   
	 * */
	@Test
	public void testAddingPassengerAfterAnotherPassengerBoarding() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 7;
		Integer addingNewPassenger = 8;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		Integer peopleNotGetSeat = ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		peopleNotGetSeat = ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) addingNewPassenger);
		
		Integer expectedPeopleNotGetSeat = newPassengers + addingNewPassenger - numberOfSeats;
		
		assertEquals(expectedPeopleNotGetSeat, peopleNotGetSeat);
		
	}
	
	/**
	 * Create numberOfSeats() method in passenger class which is an accessor  
	 * for number of seats that is supplied when create Passenger Car instance
	 * */
	@Test
	public void testNumberOfSeatsofPassengerCar() throws TrainException {
		Integer grossWeight = 1;
		Integer expectedNumberOfSeats = 10;
		
		asgn2RollingStock.RollingStock passengerUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)expectedNumberOfSeats);
		
		Integer actualNumberOfSeats = ((asgn2RollingStock.PassengerCar)passengerUnderTest).numberOfSeats(); 
		
		assertEquals(expectedNumberOfSeats, actualNumberOfSeats);
	}
	
	/**
	 * Create numberOnBoard() method in PassengerCar class which is an accessor  
	 * for number passenger on board
	 * */
	@Test
	public void testNumberOnBoardOfPassengerCar() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 5;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		Integer numOnBoard = ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).numberOnBoard();
		
		assertEquals(newPassengers, numOnBoard);
		
	}
	
	/**
	 * Create toString() method in passenger class that return a string to represent
	 * the passenger car object.
	 * 
	 * */
	@Test 
	public void testPassengerCarToString() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 5;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		String passengerCarString = ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).toString();
		
		assertEquals("Passenger(5/10)", passengerCarString);
	}
	
	/**
	 * Create alight method in  passenger class that taken the departing passengers
	 * as parameter. This method would decrease number on board.
	 * Test this method after newPassengers board. Expected number on board equals
	 * newpassenger on board minus departing passengers 
	 * */
	@Test
	public void testPassengerCarDeparting() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 5;
		Integer departingPassengers = 3;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		//board
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		//depart
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).alight((Integer) departingPassengers );
		
		Integer expectedPassengersOnBoard = newPassengers - departingPassengers;
		
		assertEquals(expectedPassengersOnBoard, ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).numberOnBoard());
	}
	
	/**
	 * Create test for passenger class
	 * Test for passenger departing twice
	 * Start with valid input of gross weight, number of seat and passenger
	 * continue with two times of valid departing passenger input
	 * */
	@Test
	public void testPassengerDepartingTwice() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 9;
		Integer departingPassengers_1 = 3;
		Integer departingPassengers_2 = 4;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).alight((Integer) departingPassengers_1 );
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).alight((Integer) departingPassengers_2 );
		
		Integer expectedPassengersOnBoard = newPassengers - departingPassengers_1 - departingPassengers_2;
		
		assertEquals(expectedPassengersOnBoard, ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).numberOnBoard());
	}
	
	/**
	 * Create test for passenger class
	 * Test for passenger departing with negative input
	 * Start with valid input of gross weight, number of seats and passengers
	 * continue with negative input of departing passenger
	 * */
	@Test(expected = TrainException.class)
	public void testPassengerCarAlightWithNegativeDepartingPassengers() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 5;
		Integer departingPassengers = -10;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).alight((Integer) departingPassengers );
		
		
	}
	
	/**
	 * Create test for passenger car
	 * Test for number of passengers departing is more than passenger on board of passenger car
	 * Start with valid input of gross weight, number of seat and passengers
	 * Continue with number of departing passenger more than on boarding passenger input
	 * Expecting TrainException
	 * */
	@Test(expected = TrainException.class)
	public void testPassengerCarAlightWithDepartingPassengersBiggerThanNumOnBoard() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 5;
		Integer departingPassengers = 10;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).alight((Integer) departingPassengers );
		
		
	}
	
	/**
	 * Create test for passenger class
	 * Test for passenger departing twice 
	 * with total departing passenger is greater than on boarding passenger
	 * 
	 * @exception TrainException
	 * */
	@Test(expected = TrainException.class)
	public void testPassengerCarAlightWithTotalDepartingPassengersBiggerThanNumOnBoard() throws TrainException
	{
		Integer grossWeight = 1;
		Integer numberOfSeats = 10;
		Integer newPassengers = 5;
		Integer departingPassengers_1 = 7;
		Integer departingPassengers_2 = 5;
		
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).alight((Integer) departingPassengers_1 );
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).alight((Integer) departingPassengers_2 );
		
	}
}
