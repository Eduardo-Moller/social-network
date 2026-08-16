package com.social.network.model.dto.command.user;

public record CreateUserCommand(
		String username,
		String email,
		String password
) {
}
