package com.example.moviecatalogservice.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = {
			MethodArgumentNotValidException.class,
			HttpMessageNotReadableException.class,
			MethodArgumentTypeMismatchException.class
	})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, String> badRequest(Exception exception) {
		exception.printStackTrace();
		Map<String, String> response  = new LinkedHashMap<>();
		response.put("Bad request", "Sorry");
		return response;
	}
}
