package com.cts.seller.exception;

public class NoSuchProductException extends RuntimeException {
	
	private String message;

	public NoSuchProductException() {
	}

	public NoSuchProductException(String message) {
		super();
		this.message = message;
	}
	
	
}
