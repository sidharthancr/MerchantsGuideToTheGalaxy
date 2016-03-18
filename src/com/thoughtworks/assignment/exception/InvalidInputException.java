package com.thoughtworks.assignment.exception;

/**
 * The Class InvalidInputException is a customized exception to throw exception
 * when input is not formatted.
 */
public class InvalidInputException extends Exception {

	/**
	 * Unique Serial ID
	 */
	private static final long serialVersionUID = 8478220447144010850L;

	/**
	 * Constructor to a new invalid input exception.
	 * 
	 * @param message
	 *            the message
	 */
	public InvalidInputException(String message) {
		super(message);
	}

}
