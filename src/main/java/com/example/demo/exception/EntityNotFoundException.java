package com.example.demo.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
	@Getter
	private ErrorCodes errorcode;
	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
	public EntityNotFoundException(String message,Throwable cause,ErrorCodes errorcode) {
		super(message,cause);
		this.errorcode=errorcode;
	}
	public EntityNotFoundException(String message,ErrorCodes errorcode) {
		super(message);
		this.errorcode=errorcode;
	}

}
