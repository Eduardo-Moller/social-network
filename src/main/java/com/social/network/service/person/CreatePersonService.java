package com.social.network.service.person;

import com.social.network.model.dto.request.person.CreatePersonRequest;
import com.social.network.model.dto.response.person.CreatePersonResponse;

public interface CreatePersonService {

	CreatePersonResponse execute(CreatePersonRequest request);
}
