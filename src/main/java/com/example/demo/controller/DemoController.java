//package com.example.demo.controller;
//
//import java.util.stream.Collectors;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Validated
//public class DemoController {
//	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	  public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
//	    String errorMessage = ex.getBindingResult().getFieldErrors().stream()
//	            .map(FieldError::getDefaultMessage)
//	            .collect(Collectors.joining(", "));
//	    return ResponseEntity.badRequest().body(errorMessage);
//	  }
//	
//
//}
