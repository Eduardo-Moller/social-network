package com.social.network.service.auth;

import com.social.network.model.entity.User;

public interface GenerateTokenService {

	String execute(User user);
}
