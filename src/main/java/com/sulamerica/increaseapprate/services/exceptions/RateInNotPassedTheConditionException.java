package com.sulamerica.increaseapprate.services.exceptions;

public class RateInNotPassedTheConditionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RateInNotPassedTheConditionException(String msg) {
		super(msg);
	}
	
	public RateInNotPassedTheConditionException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
