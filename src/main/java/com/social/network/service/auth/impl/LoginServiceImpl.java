package com.social.network.service.auth.impl;

import static com.social.network.service.auth.impl.GenerateTokenServiceImpl.TOKEN_DEFAULT_EXPIRES_IN;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.social.network.exception.UnauthorizedException;
import com.social.network.mapper.auth.LoginMapper;
import com.social.network.model.dto.request.auth.LoginRequest;
import com.social.network.model.dto.response.auth.LoginResponse;
import com.social.network.repository.UserRepository;
import com.social.network.service.auth.GenerateTokenService;
import com.social.network.service.auth.LoginService;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final GenerateTokenService generateTokenService;
	private final PasswordEncoder passwordEncoder;
	private final LoginMapper loginMapper;
	private final UserRepository userRepository;

	@Override
	public LoginResponse execute(LoginRequest request) {
		var user = userRepository.findByUsernameAndDeletedAtIsNull(request.getUsername());

		if (user.isPresent() && isPasswordMatching(request.getPassword(), user.get().getPasswordHash())) {
			var token = generateTokenService.execute(user.get());

			return loginMapper.toResponse(String.valueOf(TOKEN_DEFAULT_EXPIRES_IN), token);
		}

		throw new UnauthorizedException();
	}

	private boolean isPasswordMatching(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
