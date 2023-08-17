package com.example.demo.exception;

import lombok.Getter;

public class EntityAlreadyExistsException  extends RuntimeException {
	@Getter
	private ErrorCodes errorcode;
	public EntityAlreadyExistsException(String message) {
		super(message);
	}
	
	public EntityAlreadyExistsException(String message,Throwable cause) {
		super(message,cause);
	}
	public EntityAlreadyExistsException(String message,Throwable cause,ErrorCodes errorcode) {
		super(message,cause);
		this.errorcode=errorcode;
	}
	public EntityAlreadyExistsException(String message,ErrorCodes errorcode) {
		super(message);
		this.errorcode=errorcode;
	}
}
