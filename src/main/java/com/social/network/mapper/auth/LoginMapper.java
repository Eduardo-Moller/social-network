package com.social.network.mapper.auth;

import org.mapstruct.Mapper;

import com.social.network.model.dto.response.auth.LoginResponse;

@Mapper(componentModel = "spring")
public interface LoginMapper {

	LoginResponse toResponse(String expiresIn, String token);
}
