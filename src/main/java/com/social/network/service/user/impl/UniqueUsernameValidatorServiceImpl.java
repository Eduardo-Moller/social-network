package com.social.network.service.user.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.social.network.exception.ResourceAlreadyExistsException;
import com.social.network.exception.keys.ExceptionKeys;
import com.social.network.repository.UserRepository;
import com.social.network.service.user.UniqueUsernameValidatorService;

@Service
@RequiredArgsConstructor
public class UniqueUsernameValidatorServiceImpl implements UniqueUsernameValidatorService {

	private final UserRepository userRepository;

	@Override
	public void validate(String username) {
		if (userRepository.existsByUsername(username)) {
			throw new ResourceAlreadyExistsException(
					ExceptionKeys.USERNAME_ALREADY_REGISTERED_CODE,
					ExceptionKeys.USERNAME_ALREADY_REGISTERED_MESSAGE
			);
		}
	}
}
