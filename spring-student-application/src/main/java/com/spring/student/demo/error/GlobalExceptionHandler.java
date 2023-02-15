package com.spring.student.demo.error;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> bookException(BookNotFoundException ex,WebRequest req){
		Error error = new Error(req.getDescription(true),ex.getMessage() , LocalDate.now());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		
	}

}
