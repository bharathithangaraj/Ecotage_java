package com.ecotage.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<String>  handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {
		
//		ResponseEntity<>
		ExceptionReponse error = new ExceptionReponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
//
//		return error;
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
		
		//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionReponse handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionReponse error = new ExceptionReponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}


}
