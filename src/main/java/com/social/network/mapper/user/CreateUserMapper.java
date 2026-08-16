package com.social.network.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.social.network.model.dto.command.user.CreateUserCommand;
import com.social.network.model.entity.User;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {

	@Mapping(target = "passwordHash", source = "passwordHash")
	User toEntity(CreateUserCommand command, String passwordHash);
}
