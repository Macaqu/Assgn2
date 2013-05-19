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
	 * Create test for FreightCar class 
	 * start test with calling valid good type and gross weight
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
	 * Create test for FreightCar class 
	 * Start test with calling valid good type and invalid gross weight
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
	 * Create test for FreightCar class
	 * start test with calling invalid good type and valid gross weight
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
	 * Create test for freight car 
	 * Start test with calling null good type and valid gross weight
	 * */
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidNullGoodsType() throws TrainException
	{
		String invalidNullGoodsType = null;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidNullGoodsType = 
				new asgn2RollingStock.FreightCar(validGrossWeight , invalidNullGoodsType);
	}
	
	/**
	 * Create test for freight car 
	 * Start test with calling both invalid good type and gross weight
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
	 * Create test for Gross weight of Freight car
	 * Start the test with calling valid gross weight for valid goods type
	 * */
	@Test
	public void testGetGrossWeightOfFreightCar() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		assertEquals(grossWeight, freightCarUnderTest.getGrossWeight());
	}
	
	/**
	 * Create test to get good type of freight car
	 * start the test with calling valid gross weight and goods type
	 * 
	 * */
	@Test
	public void testGetGoodsTypeOfFreightCar() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		assertEquals(goodsType, ((asgn2RollingStock.FreightCar) freightCarUnderTest).goodsType());
	}
	
	/**
	 * Create test for FreightCar class 
	 * Start with valid gross weight and goodsType
	 * Expected valid string goods type output 
	 * 
	 * */
	@Test
	public void testFreightCarToString() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		String expectedString = "Freight(G)";
		String actualString = freightCarUnderTest.toString();
		assertEquals(expectedString, actualString);
	}
	
	/*LOCOMOTIVE*/
	/**
	 * Create test for locomotive class
	 * Start with valid gross weight and valid classification
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
	 * Create test for locomotive class
	 * Start with valid classification input and invalid gross weight input
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
	 * Create test for locomotive class
	 * Start with invalid specification input and valid Gross Weight
	 * 
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
	 * Create test for locomotive class
	 * Start with invalid specification and valid gross weight
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
	 * Create test for locomotive class
	 * Start with null specification input and valid gross weight
	 * */
	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidNullSpecification() throws TrainException
	{
		String invalidNullSpecification = null;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidNullSpecification = 
			new asgn2RollingStock.FreightCar(validGrossWeight , invalidNullSpecification);
	}
	
	/**
	 * Create test for locomotive class
	 * Test to get locomotive power
	 * Start with valid gross weight and classification input
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
	 * Create test for locomotive class
	 * Test to override string to locomotive class
	 * Start with gross weight for current string classification and expectedString
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
	 * Create test for locomotive class
	 * Test to get locomotive gross weight
	 * Start with valid gross weight and classification
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
	 * Create test for passenger class
	 * start with valid gross weight and number of seat input
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
	 * Create test for passenger class
	 * Start with valid number of seat and invalid gross weight input
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
	 * Create Test for passenger class
	 * Start with invalid number of seat and valid gross weight input
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
	 * Create test for passenger class
	 * Start with null number of seat and valid gross weight input
	 * */
	@Test(expected = NullPointerException.class)
	public void testCreatePassengerCarWithInvalidNullSNumberOfSeats() throws TrainException
	{
		Integer invalidNullNumberOfSeats = null;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarWithInvalidNullSpecification = 
			new asgn2RollingStock.PassengerCar((Integer)validGrossWeight , (Integer)invalidNullNumberOfSeats);
	}
	
	/**
	 * Create test for passenger class 
	 * Test for passenger board in passenger car
	 * Start with number of passengers less than number of seats input
	 * With valid gross weight input 
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
		Integer peopleNotGetSeat = ((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
		assertEquals("expected = " + expectedPeopleNotGetSeat.toString() + " but " + peopleNotGetSeat.toString(),
				expectedPeopleNotGetSeat, peopleNotGetSeat);
	}
	
	/**
	 * Create test for passenger class 
	 * Test for passenger board in passenger car
	 * Start with number of passenger board more than number of seats
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
	 * Create test for passenger class
	 * Test for passenger board in passenger car
	 * Start with valid input of gross weight, number of seat and passenger
	 * Adding new passenger input in passenger car
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
	 * Create test for passenger class
	 * Test for number of seat in passenger car
	 * Start with valid gross weight and expected number of seat input
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
	 * Create test for passenger class
	 * Test for number on board of passenger in passenger car
	 * Start with valid gross weight, number of seat and passenger input
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
	 * Create test for passenger class
	 * Test for passenger car toString
	 * Start with valid gross weight, number of seat and passenger input
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
	 * Create test for passenger class
	 * Test for passenger departing from passenger car
	 * Start with gross weight, number of seat and new passenger input
	 * continue with number of departing passengers  
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
		
		((asgn2RollingStock.PassengerCar)passengerCarUnderTest).board((Integer) newPassengers);
		
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
	 * Expecting TrainException
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
