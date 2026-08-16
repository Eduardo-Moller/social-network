package com.social.network.service.user.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.social.network.mapper.user.CreateUserMapper;
import com.social.network.model.dto.command.user.CreateUserCommand;
import com.social.network.model.entity.User;
import com.social.network.repository.UserRepository;
import com.social.network.service.user.CreateUserService;
import com.social.network.service.user.UniqueEmailValidatorService;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {

	private final UniqueEmailValidatorService uniqueEmailValidatorService;
	private final PasswordEncoder passwordEncoder;
	private final CreateUserMapper createUserMapper;
	private final UserRepository userRepository;

	@Override
	public User execute(CreateUserCommand command) {
		uniqueEmailValidatorService.validate(command.email());

		var passwordHash = passwordEncoder.encode(command.password());
		User user = createUserMapper.toEntity(command, passwordHash);

		return userRepository.save(user);
	}
}
