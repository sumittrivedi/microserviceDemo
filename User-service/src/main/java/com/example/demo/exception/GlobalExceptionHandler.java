package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Data;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> defaultexception() {
		ErrorMessage errorMessage= new ErrorMessage();
		errorMessage.setMessage("Inavild Input");
		errorMessage.setDescription("we do not something to serve for your request parameter");
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
@Data
class ErrorMessage{
	String message;
	String description;
}