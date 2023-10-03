package com.example.restlab.model.exceptions;

public class RestEntityNotFoundException extends RuntimeException {
    public RestEntityNotFoundException() {
		this("Entity Not Found");
	}

	public RestEntityNotFoundException(String message) {
		super(message);
	}

	public RestEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public RestEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
