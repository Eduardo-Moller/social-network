package com.social.network.service.auth.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.social.network.model.dto.request.auth.LoginRequest;
import com.social.network.model.dto.response.auth.LoginResponse;
import com.social.network.service.auth.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	@Override
	public LoginResponse login(LoginRequest request) {
		return null;
	}
}
