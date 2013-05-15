package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;

public class RollingStockTests {
 
	
	@Test
	public void testCreateFreightCar() throws TrainException {
		Integer grossWeight = 1;
		String goodsType = "G";
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarUnderTest =  
			new asgn2RollingStock.FreightCar((Integer)grossWeight, (String)goodsType);
		
	}
	
	
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidGrossWeight() throws TrainException
	{
		String validGoodsType = "G";
		Integer invalidGrossWeight = -1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidGrossWeight = 
				new asgn2RollingStock.FreightCar(invalidGrossWeight , validGoodsType);
	}
	
	
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidGoodsType() throws TrainException
	{
		String invalidGoodsType = "Z";
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidGoodsType = 
				new asgn2RollingStock.FreightCar(validGrossWeight , invalidGoodsType);
	}
	
	
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidNullGoodsType() throws TrainException
	{
		String invalidNullGoodsType = null;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidNullGoodsType = 
				new asgn2RollingStock.FreightCar(validGrossWeight , invalidNullGoodsType);
	}
	
	
	@Test(expected = TrainException.class)
	public void testCreateFreightCarWithInvalidBothArguments() throws TrainException
	{
		String invalidGoodsType = "K";
		Integer invalidGrossWeight = -9;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock freightCarWithInvalidGrossWeight = 
				new asgn2RollingStock.FreightCar(invalidGrossWeight , invalidGoodsType);
	}
	
	
	@Test
	public void testGetGrossWeightOfFreightCar() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		assertEquals(grossWeight, freightCarUnderTest.getGrossWeight());
	}
	
	@Test
	public void testGetGoodsTypeOfFreightCar() throws TrainException
	{
		Integer grossWeight = 1;
		String goodsType = "G";
		
		asgn2RollingStock.RollingStock freightCarUnderTest =  new asgn2RollingStock.FreightCar(grossWeight, goodsType);
		
		assertEquals(goodsType, ((asgn2RollingStock.FreightCar) freightCarUnderTest).goodsType());
	}
	
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
	
	@Test
	public void testCreateLocomotive() throws TrainException {
		Integer grossWeight = 1;
		String classification = "9E";
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveUnderTest =  
			new asgn2RollingStock.Locomotive((Integer)grossWeight, (String)classification);
		
	}
	
	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidGrossWeight() throws TrainException
	{
		String validClassification = "5E";
		Integer invalidGrossWeight = -1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidGrossWeight = 
				new asgn2RollingStock.Locomotive(invalidGrossWeight , validClassification);
	}
	

	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidSpecification() throws TrainException
	{
		String invalidSpecification = "3Z";
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidSpecification = 
				new asgn2RollingStock.Locomotive(validGrossWeight , invalidSpecification);
	}

	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidOneDigitSpecification() throws TrainException
	{
		String invalidSpecification = "Z";
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidSpecification = 
				new asgn2RollingStock.Locomotive(validGrossWeight , invalidSpecification);
	}

	
	@Test(expected = TrainException.class)
	public void testCreateLocomotiveWithInvalidNullSpecification() throws TrainException
	{
		String invalidNullSpecification = null;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock locomotiveWithInvalidNullSpecification = 
			new asgn2RollingStock.FreightCar(validGrossWeight , invalidNullSpecification);
	}
	
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
	
	@Test
	public void testLocomotiveToStringIsOverriden() throws TrainException {
		Integer grossWeight = 1;
		String classification = "9E";
		String expectedString = "Loco(9E)";
		
		asgn2RollingStock.RollingStock locomotiveUnderTest =  
			new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		assertEquals(((asgn2RollingStock.Locomotive)locomotiveUnderTest).toString(), expectedString);
	}
	
	@Test
	public void testLocomotiveGetGrossWeight() throws TrainException {
		Integer validGrossWeight = 1;
		String validClassification = "9E";
		
		asgn2RollingStock.RollingStock locomotiveUnderTest =  
			new asgn2RollingStock.Locomotive(validGrossWeight, validClassification);
		
		assertEquals(((asgn2RollingStock.Locomotive)locomotiveUnderTest).getGrossWeight(), validGrossWeight);
	}
	
	/*PASSENGER CAR*/
	@Test
	public void testCreatePassengerCar() throws TrainException {
		Integer grossWeight = 1;
		Integer numberOfSeats = 1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)numberOfSeats);
		
	}
	
	@Test(expected = TrainException.class)
	public void testCreatePassengerCarWithInvalidGrossWeight() throws TrainException
	{
		Integer validNumberOfSeats = 5;
		Integer invalidGrossWeight = -1;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarWithInvalidGrossWeight = 
				new asgn2RollingStock.PassengerCar((Integer)invalidGrossWeight, (Integer)validNumberOfSeats);
	}

	@Test(expected = TrainException.class)
	public void testCreatePassengerCarWithInvalidNumberOfSeats() throws TrainException
	{
		Integer invalidNumberOfSeats = -5;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarWithInvalidNumberOfSeats = 
				new asgn2RollingStock.PassengerCar((Integer)validGrossWeight , (Integer)invalidNumberOfSeats);
	}

	@Test(expected = NullPointerException.class)
	public void testCreatePassengerCarWithInvalidNullSNumberOfSeats() throws TrainException
	{
		Integer invalidNullNumberOfSeats = null;
		Integer validGrossWeight = 5;
		
		@SuppressWarnings("unused")
		asgn2RollingStock.RollingStock passengerCarWithInvalidNullSpecification = 
			new asgn2RollingStock.PassengerCar((Integer)validGrossWeight , (Integer)invalidNullNumberOfSeats);
	}
	
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
	
	@Test
	public void testNumberOfSeatsofPassengerCar() throws TrainException {
		Integer grossWeight = 1;
		Integer expectedNumberOfSeats = 10;
		
		asgn2RollingStock.RollingStock passengerUnderTest =  
			new asgn2RollingStock.PassengerCar((Integer)grossWeight, (Integer)expectedNumberOfSeats);
		
		Integer actualNumberOfSeats = ((asgn2RollingStock.PassengerCar)passengerUnderTest).numberOfSeats(); 
		
		assertEquals(expectedNumberOfSeats, actualNumberOfSeats);
	}
	
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
	
	@Test
	public void testPassengerCarAlight() throws TrainException
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
