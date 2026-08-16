package com.social.network.exception.keys;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionKeys {

	public static final String VALIDATION_ERROR_CODE = "validation.error";
	public static final String NOT_READABLE_REQUEST_BODY_CODE = "not.readable.request.body";
	public static final String EMAIL_ALREADY_REGISTERED_CODE = "email.already.registered";

	public static final String VALIDATION_ERROR_DEFAULT_MESSAGE = "Erro ao validar o objeto";
	public static final String NOT_READABLE_REQUEST_BODY_MESSAGE = "Não foi possível ler o corpo da requisição";
	public static final String EMAIL_ALREADY_REGISTERED_MESSAGE = "Email já cadastrado";
}
