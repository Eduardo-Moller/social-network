package com.social.network.model.dto.request.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	@NotBlank(message = "nome de usúario não pode ser nulo e ou vazio")
	private String username;

	@NotBlank(message = "senha não pode ser nulo e ou vazio")
	private String password;
}
