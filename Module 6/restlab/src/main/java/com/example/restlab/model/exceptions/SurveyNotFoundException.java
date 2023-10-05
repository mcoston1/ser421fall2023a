package com.example.restlab.model.exceptions;

public class SurveyNotFoundException extends RuntimeException {
    public SurveyNotFoundException() {
		this("Survey Not Found");
	}

	public SurveyNotFoundException(String message) {
		super(message);
	}

	public SurveyNotFoundException(Throwable cause) {
		super(cause);
	}

	public SurveyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SurveyNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
