package com.social.network.exception;

import org.springframework.http.HttpStatus;

import com.social.network.exception.keys.ExceptionKeys;
import com.social.network.model.enums.ErrorTypeEnum;

public class UnauthorizedException extends BaseException {

	public UnauthorizedException() {
		super(
				HttpStatus.UNAUTHORIZED,
				ErrorTypeEnum.TECHNICAL_ERROR,
				ExceptionKeys.UNAUTHORIZED_ERROR_CODE,
				ExceptionKeys.UNAUTHORIZED_ERROR_MESSAGE
		);
	}
}
