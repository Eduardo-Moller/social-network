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

import com.social.network.model.dto.request.person.CreatePersonRequest;
import com.social.network.model.dto.response.person.CreatePersonResponse;
import jakarta.validation.Valid;

public interface PersonApi {

	@PostMapping
	@Operation(
			summary = "Create a new account",
			description = "Creates a new account using the provided registration details."
	)
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "201",
							description = "Account created successfully",
							content = {
									@Content(
											mediaType = MediaType.APPLICATION_JSON_VALUE,
											schema = @Schema(implementation = CreatePersonResponse.class)
									)
							}
					)
			}
	)
	ResponseEntity<CreatePersonResponse> create(@Valid @RequestBody CreatePersonRequest request);
}
