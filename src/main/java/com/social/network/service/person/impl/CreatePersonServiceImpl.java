package com.social.network.service.person.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.social.network.mapper.person.CreatePersonMapper;
import com.social.network.model.dto.request.person.CreatePersonRequest;
import com.social.network.model.dto.response.person.CreatePersonResponse;
import com.social.network.repository.PersonRepository;
import com.social.network.service.person.CreatePersonService;
import com.social.network.service.user.CreateUserService;

@Service
@RequiredArgsConstructor
public class CreatePersonServiceImpl implements CreatePersonService {

	private final CreateUserService createUserService;
	private final CreatePersonMapper createPersonMapper;
	private final PersonRepository personRepository;

	@Override
	public CreatePersonResponse execute(CreatePersonRequest request) {
		var userCommand = createPersonMapper.toUserCommand(request);
		var user = createUserService.execute(userCommand);

		var person = createPersonMapper.toEntity(request, user);
		personRepository.save(person);

		return createPersonMapper.toResponse(person, user);
	}
}
