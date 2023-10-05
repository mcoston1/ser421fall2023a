package com.example.restlab.model.exceptions;

public class SurveyInstanceNotFoundException extends RuntimeException {
    public SurveyInstanceNotFoundException() {
		this("Survey Not Found");
	}

	public SurveyInstanceNotFoundException(String message) {
		super(message);
	}

	public SurveyInstanceNotFoundException(Throwable cause) {
		super(cause);
	}

	public SurveyInstanceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SurveyInstanceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
