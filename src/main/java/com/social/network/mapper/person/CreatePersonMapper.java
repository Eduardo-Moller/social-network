package com.social.network.mapper.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.social.network.model.dto.command.user.CreateUserCommand;
import com.social.network.model.dto.request.person.CreatePersonRequest;
import com.social.network.model.dto.response.person.CreatePersonResponse;
import com.social.network.model.entity.Person;
import com.social.network.model.entity.User;

@Mapper(componentModel = "spring")
public interface CreatePersonMapper {

	@Mapping(target = "user", source = "user")
	@Mapping(target = "bio", ignore = true)
	@Mapping(target = "avatarUrl", ignore = true)
	Person toEntity(CreatePersonRequest request, User user);

	@Mapping(target = "id", source = "person.id")
	@Mapping(target = "userId", source = "user.id")
	@Mapping(target = "username", source = "user.username")
	@Mapping(target = "email", source = "user.email")
	CreatePersonResponse toResponse(Person person, User user);

	CreateUserCommand toUserCommand(CreatePersonRequest request);
}
