package com.cts.seller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cts.seller.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value = NoSuchProductException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody com.cts.seller.model.ErrorResponse handleException(NoSuchProductException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
}
