package com.example.demo.handlers;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InvalidEntityException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(Exception ex) {
        return new ErrorResponse("Bad Request", ex.getMessage());
    }

    
    @ExceptionHandler(value = { AccessDeniedException.class })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleAccessDeniedException(AccessDeniedException ex) {
        return new ErrorResponse("Access Denied", ex.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleServerError(Exception ex) {
        return new ErrorResponse("Internal Server Error", ex.getMessage());
    }
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception,WebRequest webRequest){
    	final HttpStatus notFound=HttpStatus.NOT_FOUND;
    	  final ErrorDto x=ErrorDto.builder()
    	.code(exception.getErrorcode())
    	.httpCode(notFound.value())
    	.message(exception.getMessage())
    	.build();
    	   return new ResponseEntity<> (x,notFound);
    }
    
    @ExceptionHandler(value = {InvalidEntityException.class})
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception,WebRequest webRequest){
    	final HttpStatus badRequest=HttpStatus.BAD_REQUEST;
    	final ErrorDto errorDto=ErrorDto.builder()
    	.code(exception.getErrorcode())
    	.httpCode(badRequest.value())
    	.message(exception.getMessage())
    	.errors(exception.getErrors())
    	.build();
    	return new ResponseEntity<> (errorDto,badRequest);
    }
    
}