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
	 * @note create class of Departing train in package asgn2Train
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
	 * @note create method addCarriage that pass parameter newCarriage in the RollingStock data type
	 * */
	@Test
	public void testAddLocomotive() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
	}
	
	/**
	 * Create test does the train can move the departing train or not
	 * Start with valid input of gross weight and classification
	 * 
	 * @note create method trainCanMove() that returns boolean true if the train is overloaded
	 * */
	@Test
	public void testTrainCanMove() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage  = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		boolean trainCanMove = train.trainCanMove();
		assertTrue(trainCanMove);
	}
	
	/**
	 * Create test to remove carriage
	 * Start with valid input of gross weight and classification
	 * Continue with adding another carriage with specific classification
	 * 
	 * @throws TrainException if either one or both grossWeight and classification is supplied
	 * 
	 * @note create method removeCarriage() in DepartingTrain class
	 * */
	@Test
	public void testRemoveCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage  = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		Integer freightCarGrossWeight = 5;
		String freightCarGoodsType = "R";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar( freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		train.removeCarriage();
		
		assertFalse(train.nextCarriage() instanceof FreightCar);
	}
	
	
	/**
	 * Create test for first carriage on departing train
	 * start with valid input of gross weight and classification
	 * 
	 * @throws TrainException if either one or both grossWeight and classification is supplied
	 * 
	 * @note create method firstCarriage() in the DepartingTrain class 
	 * that return the first carriage in the RollingStock type 
	 * if the carriage in the train not null. Otherwise return null
	 * 
	 */
	@Test
	public void testFirstCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		RollingStock firstCarriage = train.firstCarriage();
		
		assertTrue(firstCarriage instanceof Locomotive);
	}
	
	/**
	 * Create test for the next carriage
	 * Start with adding locomotive valid input
	 * continue with another carriage valid input
	 * 
	 * @throws TrainException
	 * @note : create nextCarriage() method in DepartingTrain class
	 */
	@Test
	public void testNextCarriageAfterFirstCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer freightCarGrossWeight = 5;
		String freightCarGoodsType = "R";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar( freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		@SuppressWarnings("unused")
		RollingStock firstCarriage = train.firstCarriage();
		RollingStock nextCarriage = train.nextCarriage();
		assertTrue(nextCarriage instanceof FreightCar);
	}
	
	/**
	 * Create test for the next carriage
	 * Start with adding locomotive valid input
	 * continue with two carriages valid input
	 * Call locomotive with firstCarriage() method. Continue with call nextCarriage() twice.
	 * Call firstCarriage() again. Expected firstCarriage in the first call is the same  
	 * same object with firstCarriage in the last call.
	 * 
	 * @throws TrainException
	 */
	@Test
	public void testFirstCarriageAfterNextCarriages() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock locomotive = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)locomotive);
		
		//add second carriage
		Integer psgCarGrossWeight = 5;
		Integer psgCarNumOfSeats = 100;
		asgn2RollingStock.RollingStock passengerCar = 
				new asgn2RollingStock.PassengerCar(psgCarGrossWeight, psgCarNumOfSeats);
		train.addCarriage(passengerCar);
		
		//add third carriage
		Integer freightCarGrossWeight = 5;
		String freightCarGoodsType = "R";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar( freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		RollingStock firstCarriage = train.firstCarriage();
		@SuppressWarnings("unused")
		RollingStock secondCarriage = train.nextCarriage();
		@SuppressWarnings("unused")
		RollingStock thirdCarriage = train.nextCarriage();
		RollingStock recallFirstCarriage = train.firstCarriage();
		assertTrue(firstCarriage.equals(recallFirstCarriage));
	}
	
	/**
	 * Create test for the next carriage
	 * Start with adding locomotive valid input
	 * Call locomotive with nextCarriage() method. 
	 * 
	 * @throws TrainException
	 */
	@Test
	public void testNextCarriageWithoutFirstCarriages() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock locomotive = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		
		train.addCarriage((asgn2RollingStock.RollingStock)locomotive);
		
		assertTrue(train.nextCarriage() instanceof Locomotive);
	}
	
	/**
	 * Create test for the next carriage
	 * Start with adding locomotive valid input
	 * continue with another carriage valid input
	 * 
	 * @throws TrainException
	 */
	@Test
	public void testCallNextCarriageTwice() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer freightCarGrossWeight = 5;
		String freightCarGoodsType = "R";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar( freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		@SuppressWarnings("unused")
		RollingStock firstCarriage = train.nextCarriage();
		RollingStock nextCarriage = train.nextCarriage();
		assertTrue(nextCarriage instanceof FreightCar);
	}
	
	/**
	 * Create test for the next carriage
	 * Start with adding locomotive valid input
	 * continue with another carriage valid input until return null
	 * Make sure that the next carriage return null if call above the bound 
	 * 
	 * @throws TrainException
	 */
	@Test
	public void testCallNextCarriageUntilReturnNull() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer freightCarGrossWeight = 5;
		String freightCarGoodsType = "R";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar( freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		@SuppressWarnings("unused")
		RollingStock firstCarriage = train.nextCarriage();
		@SuppressWarnings("unused")
		RollingStock scndCarriage = train.nextCarriage();
		RollingStock thirdCarriage = train.nextCarriage();
		assertNull(thirdCarriage);
	}
	
	/**
	 * Create test for passenger board on departing train
	 * Start with adding locomotive valid input
	 * continue with adding carriage valid input
	 * followed by passenger valid input
	 * 
	 * @throws TrainException
	 * @note create board() method in DepartingTrain class
	 */
	@Test
	public void testPassengerBoard() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 10;
		asgn2RollingStock.RollingStock passengerCar = 
				new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
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
	 * 
	 * @note: create numberOnBoard() method on DepartingTrain class
	 */
	@Test
	public void testGetNumberOnBoard() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add another carriage
		
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 10;
		asgn2RollingStock.RollingStock passengerCar = 
				new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
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
	 * @throws TrainException
	 */
	@Test
	public void testGetNumberOfSeats() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add first passengerCar
		Integer frstPassCarGrossWeight = 5;
		Integer frstPassCarNumOfSeats = 10;
		asgn2RollingStock.RollingStock passengerCar1 = 
				new asgn2RollingStock.PassengerCar(frstPassCarGrossWeight, frstPassCarNumOfSeats);
		train.addCarriage(passengerCar1);
		
		//add 2nd passengerCar
		Integer scndPassCarGrossWeight = 7;
		Integer scndPassCarNumOfSeats = 15;
		asgn2RollingStock.RollingStock passengerCar2 = 
				new asgn2RollingStock.PassengerCar(scndPassCarGrossWeight, scndPassCarNumOfSeats);
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
	 * 
	 * @throws TrainException
	 * 
	 * @note create toString() method in DepartingTrain 
	 */
	@Test
	public void testToString() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add passengerCar
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 24;
		asgn2RollingStock.RollingStock passengerCar = 
				new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
		
		//add freight car
		Integer freightCarGrossWeight = 7;
		String freightCarGoodsType = "G";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		Integer newPassengers = 13;
		train.board(newPassengers);
		
		String actualTrainString = train.toString();
		String expectedTrainString = "Loco(6E)-Passenger(13/24)-Freight(G)";
		assertEquals(expectedTrainString, actualTrainString);
	}

	
	/**
	 * Create test first train behind locomotive car
	 * Start with adding freight car valid input
	 * expecting TrainException class
	 * 
	 * @throws TrainException
	 */
	@Test(expected = TrainException.class)
	public void testFirstTrainNotLocomotive() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add freight car
		Integer freightCarGrossWeight = 7;
		String freightCarGoodsType = "G";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		Integer newPassengers = 13;
		train.board(newPassengers);
	}
	
	/**
	 * Create test for locomotive more than one on the same departing train
	 * Start with adding first locomotive valid input,
	 * continue with the second locomotive valid input.
	 * Expecting TrainException class
	 * 
	 * @throws TrainException
	 */
	@Test(expected = TrainException.class)
	public void testLocomotiveMoreThanOne() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight_1 = 5;
		String classification_1 = "6E";
		asgn2RollingStock.RollingStock locomotive_1 = 
				new asgn2RollingStock.Locomotive(grossWeight_1, classification_1);
		train.addCarriage((asgn2RollingStock.RollingStock)locomotive_1);
		
		//add locomotive again
		Integer grossWeight_2 = 5;
		String classification_2 = "4D";
		asgn2RollingStock.RollingStock locomotive_2 = 
				new asgn2RollingStock.Locomotive(grossWeight_2, classification_2);
		train.addCarriage((asgn2RollingStock.RollingStock)locomotive_2);
			
	}
	
	/**
	 * Create test for adding Freight car while passenger on board
	 * Start with adding locomotive valid input, passengerCar valid input followed by passenger on board 
	 * continue with adding freight car valid input
	 * Expecting TrainException
	 * 
	 * @throws TrainException
	 */
	@Test(expected = TrainException.class)
	public void testAddingFreightWhilePassengersOnBoard() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
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
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
	}
	
	/**
	 * Create test to disallowed configuration
	 * Start with valid input of locomotive, freight car and passenger car
	 * Expecting TrainException class
	 * 
	 * @throws TrainException
	 * */
	@Test(expected = TrainException.class)
	public void testDissalowedConfiguration() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
		
		//add freight car
		Integer freightCarGrossWeight = 7;
		String freightCarGoodsType = "G";
		asgn2RollingStock.RollingStock freightCar = 
				new asgn2RollingStock.FreightCar(freightCarGrossWeight, freightCarGoodsType);
		train.addCarriage(freightCar);
		
		//add passengerCar
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 24;
		asgn2RollingStock.RollingStock passengerCar = 
				new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
	}
	
	/**
	 * Create test for negative new passenger
	 * Start with adding locomotive and passenger cars valid input
	 * continue with adding negative input to passenger car
	 * Expecting TrainException class
	 * 
	 * @throws TrainException
	 * */
	@Test(expected = TrainException.class)
	public void testNegativeNewPassengers() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		//add locomotive
		Integer grossWeight = 5;
		String classification = "6E";
		asgn2RollingStock.RollingStock newCarriage = 
				new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
 
		//add passengerCar
		Integer passCarGrossWeight = 5;
		Integer passCarNumOfSeats = 24;
		asgn2RollingStock.RollingStock passengerCar = 
				new asgn2RollingStock.PassengerCar(passCarGrossWeight, passCarNumOfSeats);
		train.addCarriage(passengerCar);
		
		Integer newPassengers = -10;
		train.board(newPassengers);
	}
	
	/**
	 * Create test train exception on board. Expected firstCarriage is null.
	 * 
	 * @throws TrainException
	 * */
	@Test
	public void testFirstCarriageBeforeAddingCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		assertNull(train.firstCarriage());
	}
	
	
}
