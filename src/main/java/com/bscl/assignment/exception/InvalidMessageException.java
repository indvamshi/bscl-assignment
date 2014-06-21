package com.bscl.assignment.exception;


/**
 * Custom exception is thrown when an invalid message is sent into queue.
 * @author vchitti
 *
 */
public class InvalidMessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidMessageException(String message) {
		super(message);
	}

	public InvalidMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMessageException(Throwable cause) {
		super(cause);
	}
}
