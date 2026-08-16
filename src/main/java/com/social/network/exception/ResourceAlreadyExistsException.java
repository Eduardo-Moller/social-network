package com.social.network.exception;

import org.springframework.http.HttpStatus;

import com.social.network.model.enums.ErrorTypeEnum;

public class ResourceAlreadyExistsException extends BaseException {

	public ResourceAlreadyExistsException(String error, String message) {
		super(HttpStatus.CONFLICT, ErrorTypeEnum.VALIDATION_ERROR, error, message);
	}
}
