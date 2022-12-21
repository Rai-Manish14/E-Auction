package com.cts.buyer.exception;

public class NoSuchBuyerException extends RuntimeException {
	
	private String message;

	public NoSuchBuyerException() {
	}

	public NoSuchBuyerException(String message) {
		super();
		this.message = message;
	}
	
	
}
