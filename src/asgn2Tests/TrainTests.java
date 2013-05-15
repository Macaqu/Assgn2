package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;

public class TrainTests {

	@Test
	public void testCreateTrain()
	{
		
		@SuppressWarnings("unused")
		asgn2Train.DepartingTrain departingTrain = new asgn2Train.DepartingTrain();
	}
	
	@Test
	public void testAddLocomotive() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		Integer grossWeight = 5;
		String classification = "4E";
		asgn2RollingStock.RollingStock newCarriage = new asgn2RollingStock.Locomotive(grossWeight, classification);
		train.addCarriage((asgn2RollingStock.RollingStock)newCarriage);
	}
	
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

	@Test
	public void testGetNumberfSeats() throws TrainException
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
	
	//test train exception in board()
	@Test
	public void testFirstCarriageBeforeAddingCarriage() throws TrainException
	{
		asgn2Train.DepartingTrain train = new asgn2Train.DepartingTrain();
		
		assertNull(train.firstCarriage());
	}
	
	
}
