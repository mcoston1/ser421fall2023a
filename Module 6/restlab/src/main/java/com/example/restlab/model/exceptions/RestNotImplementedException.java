package com.example.restlab.model.exceptions;

@SuppressWarnings("serial")
public class RestNotImplementedException extends RuntimeException{
    
    public RestNotImplementedException() {
		this("Service not yet implemented");
	}

	public RestNotImplementedException(String message) {
		super(message);
	}

	public RestNotImplementedException(Throwable cause) {
		super(cause);
	}

	public RestNotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestNotImplementedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
