package com.social.network.exception.handler;

import java.time.Instant;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.social.network.exception.BaseException;
import com.social.network.exception.keys.ExceptionKeys;
import com.social.network.model.dto.response.ErrorResponse;
import com.social.network.model.enums.ErrorTypeEnum;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String message = extractError(ex);

		ErrorResponse errorResponse = ErrorResponse.builder()
				.code(status.value())
				.type(ErrorTypeEnum.VALIDATION_ERROR)
				.timestamp(Instant.now())
				.error(ExceptionKeys.VALIDATION_ERROR_CODE)
				.message(message)
				.build();

		return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException() {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ErrorResponse errorResponse = ErrorResponse.builder()
				.code(status.value())
				.type(ErrorTypeEnum.TECHNICAL_ERROR)
				.timestamp(Instant.now())
				.error(ExceptionKeys.NOT_READABLE_REQUEST_BODY_CODE)
				.message(ExceptionKeys.NOT_READABLE_REQUEST_BODY_MESSAGE)
				.build();

		return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
	}

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handeBaseException(BaseException ex) {
		ErrorResponse errorResponse = ErrorResponse.builder()
				.code(ex.getCode().value())
				.type(ex.getErrorType())
				.timestamp(Instant.now())
				.error(ex.getError())
				.message(ex.getMessage())
				.build();

		return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
	}

	private String extractError(MethodArgumentNotValidException ex) {
		Optional<ObjectError> erroOpt = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.findFirst();

		if (erroOpt.isEmpty()) {
			return ExceptionKeys.VALIDATION_ERROR_DEFAULT_MESSAGE;
		}

		FieldError erro = (FieldError) erroOpt.get();

		return erro.getDefaultMessage();
	}
}
