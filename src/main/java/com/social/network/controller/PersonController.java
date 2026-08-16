package com.social.network.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.social.network.api.PersonApi;
import com.social.network.model.dto.request.person.CreatePersonRequest;
import com.social.network.model.dto.response.person.CreatePersonResponse;
import com.social.network.service.person.CreatePersonService;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController implements PersonApi {

	private final CreatePersonService createPersonService;

	@Override
	public ResponseEntity<CreatePersonResponse> create(CreatePersonRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(createPersonService.execute(request));
	}
}
