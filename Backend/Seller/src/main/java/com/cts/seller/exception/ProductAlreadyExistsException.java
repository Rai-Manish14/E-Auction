package com.cts.seller.exception;

public class ProductAlreadyExistsException extends RuntimeException{
	
	private String message;

	public ProductAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public ProductAlreadyExistsException() {
	}
}
