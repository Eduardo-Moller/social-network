package com.social.network.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.social.network.model.dto.request.auth.LoginRequest;
import com.social.network.model.dto.response.ErrorResponse;
import com.social.network.model.dto.response.auth.LoginResponse;
import jakarta.validation.Valid;

public interface AuthApi {

	@PostMapping("/login")
	@Operation(
			summary = "Authenticate user",
			description = "Authenticates a user using their credentials and returns an authentication token."
	)
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "User authenticated successfully",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON_VALUE,
											schema = @Schema(implementation = LoginResponse.class)
									)
							}
					),
					@ApiResponse(
							responseCode = "401",
							description = "Authentication failed due to invalid credentials",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON_VALUE,
											schema = @Schema(implementation = ErrorResponse.class)
									)
							}
					)
			}
	)
	ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request);
}
