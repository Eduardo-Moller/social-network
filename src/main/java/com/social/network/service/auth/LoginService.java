package com.social.network.service.auth;

import com.social.network.model.dto.request.auth.LoginRequest;
import com.social.network.model.dto.response.auth.LoginResponse;

public interface AuthService {

	LoginResponse login(LoginRequest request);
}
