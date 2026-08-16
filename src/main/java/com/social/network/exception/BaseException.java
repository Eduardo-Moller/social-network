package com.social.network.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

import com.social.network.model.enums.ErrorTypeEnum;

@Getter
public abstract class BaseException extends RuntimeException {

	private final HttpStatus code;
	private final ErrorTypeEnum errorType;
	private final String error;

	protected BaseException(HttpStatus code, ErrorTypeEnum errorType, String error, String message) {
		super(message);
		this.code = code;
		this.errorType = errorType;
		this.error = error;
	}
}
