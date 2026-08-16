package com.social.network.model.dto.response;

import java.time.Instant;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.social.network.model.enums.ErrorTypeEnum;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private int code;
	private ErrorTypeEnum type;
	private Instant timestamp;
	private String error;
	private String message;
}
