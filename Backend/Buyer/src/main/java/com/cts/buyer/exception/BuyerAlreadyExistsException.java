package com.cts.buyer.exception;

public class BuyerAlreadyExistsException extends RuntimeException{
	
	private String message;

	public BuyerAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public BuyerAlreadyExistsException() {
	}
}
