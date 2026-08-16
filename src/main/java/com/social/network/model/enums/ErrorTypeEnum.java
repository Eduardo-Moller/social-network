package com.social.network.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorTypeEnum {
	VALIDATION_ERROR("VALIDATION_ERROR"),
	TECHNICAL_ERROR("TECHNICAL_ERROR");

	private final String value;
}
