package com.ecotage.exception;

public class ProductServiceException extends RuntimeException {
	
	public ProductServiceException() {
		super();
	}

	public ProductServiceException(final String message) {
		super(message);
	}

}
