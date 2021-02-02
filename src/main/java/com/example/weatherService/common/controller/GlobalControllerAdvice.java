package com.example.weatherService.common.controller;

import java.time.LocalDateTime;

import com.example.weatherService.common.dto.CustomErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

	private final String signature = "dfdv-hdfsdgfhsd+dsdgsdfg";

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CustomErrorDto> handleException(Exception e) {
		log.error("Global Exception", e);
		CustomErrorDto errResp = new CustomErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(errResp, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = HttpClientErrorException.class)
	public ResponseEntity handleException(HttpClientErrorException  e) {
		log.error("Global Exception", e);
		return new ResponseEntity(e.getResponseBodyAsString(), e.getStatusCode());

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<CustomErrorDto> handleException(MethodArgumentTypeMismatchException  e) {
		String name = e.getName();
		String type = e.getRequiredType().getSimpleName();
		Object value = e.getValue();
		log.error("Global Exception", e);
		String message =  name + " should be of type " + type;
		CustomErrorDto errResp = new CustomErrorDto(HttpStatus.BAD_REQUEST.value(),message, LocalDateTime.now());
		return new ResponseEntity<>(errResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { MissingServletRequestParameterException.class })
	public ResponseEntity<CustomErrorDto> handleException(MissingServletRequestParameterException e) {
		log.error("Global Exception", e);
		String message=e.getParameterName() + " parameter is missing";
		CustomErrorDto errResp = new CustomErrorDto(HttpStatus.BAD_REQUEST.value(),message, LocalDateTime.now());
		return new ResponseEntity<>(errResp, HttpStatus.BAD_REQUEST);
	}




}
