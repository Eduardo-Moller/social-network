package com.social.network.service.user;

import com.social.network.model.dto.command.user.CreateUserCommand;
import com.social.network.model.entity.User;

public interface CreateUserService {

	User execute(CreateUserCommand command);
}
