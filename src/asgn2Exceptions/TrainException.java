package asgn2Exceptions;

import java.io.Serializable;

/**
 * A simple class for exceptions thrown by railway shunting and boarding operations.
 * */


@SuppressWarnings("serial")
public class TrainException extends Exception implements Serializable{
	
	/**
	 * Constructs a new TrainException object.
	 * */
	public TrainException(String message){
		super("Train Exception: " + message);
		
	}
	
	
	
}
