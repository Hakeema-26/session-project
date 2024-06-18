
package com.batch2.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.batch2.onlineshopping.dto.ErrorMessage;

@ControllerAdvice
public class GlobalExceptions extends Exception {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> productNotFoundException(ProductNotFoundException exception,
			WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(message.getStatus()).body(message);
	}

	@ExceptionHandler(InvalidProductDetailsException.class)
	public ResponseEntity<ErrorMessage> invalidProductDetailsException(InvalidProductDetailsException exception,
			WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(message.getStatus()).body(message);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(message.getStatus()).body(message);
	}

	@ExceptionHandler(InvalidUserDetailsException.class)
	public ResponseEntity<ErrorMessage> invalidUserDetailsException(InvalidUserDetailsException exception,
			WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(message.getStatus()).body(message);
	}
}
