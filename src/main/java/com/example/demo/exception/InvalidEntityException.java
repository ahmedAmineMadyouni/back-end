package com.example.demo.exception;

import java.util.List;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException {
	@Getter
	private ErrorCodes errorcode;
	@Getter
	private List<String> errors;
	public InvalidEntityException(String message) {
		super(message);
	}
	
	public InvalidEntityException(String message,Throwable cause) {
		super(message,cause);
	}
	public InvalidEntityException(String message,Throwable cause,ErrorCodes errorcode) {
		super(message,cause);
		this.errorcode=errorcode;
	}
	public InvalidEntityException(String message,ErrorCodes errorcode) {
		super(message);
		this.errorcode=errorcode;
	}
	public InvalidEntityException(String message,ErrorCodes errorcode,List<String> errors) {
		super(message);
		this.errorcode=errorcode;
		this.errors=errors;
	}
	
}
