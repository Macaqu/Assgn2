package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;

/**
 * Test for DepartingTrain class. 
 * This test will track the configuration and passenger boarding status of whole train
 * @author Yudo Dwi Hanggodo Patriabekti
 * @version May 2013
 * 
 * */
public class TrainTests {

	/**
	 * Create test for Departing train
	 * 
	 * */
	@Test
	public void testCreateTrain()
	{
		
		@SuppressWarnings("unused")
		asgn2Train.DepartingTrain departingTrain = new asgn2Train.DepartingTrain();
	}
	
	/**
	 * Create test for adding locomotive through the departing train
	 * Start with gross weight and classification input
	 * 
	 * */
	@Test
	public void testAddLocomotive() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
	}
	
	/**
	 * Create test does the train can move the departing train or not
	 * Start with valid input of gross weight and classification
	 * 
	 * */
	@Test
	public void testTrainCanMove() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage  = new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		boolean trainCanMove = train.trainCanMove();
		assertTrue(trainCanMove);
	}
	
	/**
	 * Create test to remove carriage
	 * Start with valid input of gross weight and classification
	 * Continue with adding another carriage with specific classification
	 * 
	 * */
	@Test
	public void testRemoveCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage  = new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		Integer freightCarGrossWeight = 5;
		String freightCarGoodsType = "R";
		asgn2RollingStock.RollingStock freightCar = new asgn2RollingStock.FreightCar( freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		train.removeCarriage();
		
		assertFalse(train.nextCarriage() instanceof FreightCar);
	}
	
	/**
	 * Create test for first carriage on departing train
	 * start with valid input of gross weight and classification
	 * 
	 * */
	@Test
	public void testFirstCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		RollingStock firstCarriage = train.firstCarriage();
		
		assertTrue(firstCarriage instanceof Locomotive);
	}
	
	/**
	 * Create test for the next carriage
	 * Start with adding locomotive valid input
	 * continue with another carriage valid input
	 * 
	 * */
	@Test
	public void testNextCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer freightCarGrossWeight = 5;
		String freightCarGoodsType = "R";
		asgn2RollingStock.RollingStock freightCar = new asgn2RollingStock.FreightCar( freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		RollingStock nextCarriage = train.nextCarriage();
		assertTrue(nextCarriage instanceof FreightCar);
	}
	
	
	/**
	 * Create test for passenger board on departing train
	 * Start with adding locomotive valid input
	 * continue with adding carriage valid input
	 * followed by passenger valid input
	 * */
	@Test
	public void testPassengerBoard() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 10;
		asgn2RollingStock.RollingStock passengerCar = new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
		Integer newPassengers = 5;
		
		Integer actualpsgNotGetSeat = train.board((Integer)newPassengers);
		Integer expectedpsgNotGetSeat = 0;
		
		assertEquals(expectedpsgNotGetSeat, actualpsgNotGetSeat);
	}
	
	/**
	 * Create test to get number passenger on departing train
	 * Start with adding locomotive valid input
	 * continue with adding another carriage valid input 
	 * with specific number of passenger valid input
	 * */
	@Test
	public void testGetNumberOnBoard() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 10;
		asgn2RollingStock.RollingStock passengerCar = new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
		Integer newPassengers = 5;
		train.board(newPassengers);
		
		Integer actualpsgOnBoard = train.numberOnBoard();
		
		assertEquals(newPassengers, actualpsgOnBoard);
	}

	/**
	 * Create test to get number of seat in passenger car
	 * Start with adding locomotive valid input
	 * continue with adding first and second passenger car valid input
	 * 
	 * */
	@Test
	public void testGetNumberOfSeats() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add first passengerCar
		Integer frstPassCarGrossWeight = 5;
		Integer frstPassCarNumOfSeats = 10;
		asgn2RollingStock.RollingStock passengerCar1 = new asgn2RollingStock.PassengerCar(frstPassCarGrossWeight, frstPassCarNumOfSeats);
		train.addCarriage(passengerCar1);
		
		//add 2nd passengerCar
		Integer scndPassCarGrossWeight = 7;
		Integer scndPassCarNumOfSeats = 15;
		asgn2RollingStock.RollingStock passengerCar2 = new asgn2RollingStock.PassengerCar(scndPassCarGrossWeight, scndPassCarNumOfSeats);
		train.addCarriage(passengerCar2);
		
		Integer actualNumOfSeats = train.numberOfSeats();
		Integer expectedNumOfSeats = frstPassCarNumOfSeats + scndPassCarNumOfSeats;
		
		assertEquals(expectedNumOfSeats, actualNumOfSeats);
	}
	
	/**
	 * Create test to testToString departing train
	 * Started with adding locomotive valid input,
	 * continue with passenger and freight car valid input.
	 * Expected string output of departing train
	 * */
	@Test
	public void testToString() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add passengerCar
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 24;
		asgn2RollingStock.RollingStock passengerCar = new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
		
		//add freight car
		Integer freightCarGrossWeight = 7;
		String freightCarGoodsType = "G";
		asgn2RollingStock.RollingStock freightCar = new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		Integer newPassengers = 13;
		train.board(newPassengers);
		
		
		String actualTrainString = train.toString();
		String expectedTrainString = "Loco(6E)-Passenger(13/24)-Freight(G)";
		assertEquals(expectedTrainString, actualTrainString);
	}

	//Test TrainException in addCarriage() 
	
	/**
	 * Create test first train behind locomotive car
	 * Start with adding freight car valid input
	 * expecting TrainException class
	 * 
	 * */
	@Test(expected = TrainException.class)
	public void testFirstTrainNotLocomotive() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add freight car
		Integer freightCarGrossWeight = 7;
		String freightCarGoodsType = "G";
		asgn2RollingStock.RollingStock freightCar = new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		Integer newPassengers = 13;
		train.board(newPassengers);
	}
	
	/**
	 * Create test for locomotive more than one on the same departing train
	 * Start with adding first locomotive valid input,
	 * continue with the second locomotive valid input.
	 * Expecting TrainException class
	 * */
	@Test(expected = TrainException.class)
	public void testLocomotiveMoreThanOne() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight_1 = 5;
		String classification_1 = "6E";
		asgn2RollingStock.RollingStock locomotive_1 = new asgn2RollingStock.Locomotive(grossWeight_1, classification_1);
		train.addCarriage((asgn2RollingStock.RollingStock)locomotive_1);
		
		//add locomotive again
		Integer grossWeight_2 = 5;
		String classification_2 = "4D";
		asgn2RollingStock.RollingStock locomotive_2 = new asgn2RollingStock.Locomotive(grossWeight_2, classification_2);
		train.addCarriage((asgn2RollingStock.RollingStock)locomotive_2);
			
	}
	
	/**
	 * Create test for adding Freight car while passenger on board
	 * Start with adding locomotive valid input, passengerCar valid input followed by passenger on board 
	 * continue with adding freight car valid input
	 * 
	 * */
	@Test(expected = TrainException.class)
	public void testAddingFreightWhilePassengersOnBoard() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add passengerCar
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 24;
		asgn2RollingStock.RollingStock passengerCar = new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
		
		Integer newPassengers = 13;
		train.board(newPassengers);
		
		//add freight car
		Integer freightCarGrossWeight = 7;
		String freightCarGoodsType = "G";
		asgn2RollingStock.RollingStock freightCar = new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
	}
	
	/**
	 * Create test to disallowed configuration
	 * Start with valid input of locomotive, freight car and passenger car
	 * Expecting TrainException class
	 * */
	@Test(expected = TrainException.class)
	public void testDissalowedConfiguration() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add freight car
		Integer freightCarGrossWeight = 7;
		String freightCarGoodsType = "G";
		asgn2RollingStock.RollingStock freightCar = new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		//add passengerCar
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 24;
		asgn2RollingStock.RollingStock passengerCar = new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
	}
	
	//test train exception in board()
	/**
	 * Create test for negative new passenger
	 * Start with adding locomotive and passenger cars valid input
	 * continue with adding negative input to passenger car
	 * Expecting TrainException class
	 * */
	@Test(expected = TrainException.class)
	public void testNegativeNewPassengers() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
 
		//add passengerCar
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 24;
		asgn2RollingStock.RollingStock passengerCar = new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
		
		Integer newPassengers = -10;
		train.board(newPassengers);
	}
	
	/**
	 * Create test train exception on board
	 * 
	 * */
	@Test
	public void testFirstCarriageBeforeAddingCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		assertNull(train.firstCarriage());
	}
	
	
}
