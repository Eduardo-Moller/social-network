package com.social.network.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.social.network.api.AuthApi;
import com.social.network.model.dto.request.auth.LoginRequest;
import com.social.network.model.dto.response.auth.LoginResponse;
import com.social.network.service.auth.LoginService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

	private final LoginService loginService;

	@Override
	public ResponseEntity<LoginResponse> login(LoginRequest request) {
		return ResponseEntity.ok(loginService.execute(request));
	}
}
