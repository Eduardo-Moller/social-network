package com.social.network.service.user.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.social.network.exception.ResourceAlreadyExistsException;
import com.social.network.exception.keys.ExceptionKeys;
import com.social.network.repository.UserRepository;
import com.social.network.service.user.UniqueEmailValidatorService;

@Service
@RequiredArgsConstructor
public class UniqueEmailValidatorServiceImpl implements UniqueEmailValidatorService {

	private final UserRepository userRepository;

	@Override
	public void validate(String email) {
		if (userRepository.existsByEmailIgnoreCase(email)) {
			throw new ResourceAlreadyExistsException(
					ExceptionKeys.EMAIL_ALREADY_REGISTERED_CODE,
					ExceptionKeys.EMAIL_ALREADY_REGISTERED_MESSAGE
			);
		}
	}
}
