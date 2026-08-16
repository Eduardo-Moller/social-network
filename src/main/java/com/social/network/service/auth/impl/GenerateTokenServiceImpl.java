package com.social.network.service.auth.impl;

import java.time.Instant;
import java.util.UUID;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.social.network.model.entity.User;
import com.social.network.service.auth.GenerateTokenService;

@Service
@RequiredArgsConstructor
public class GenerateTokenServiceImpl implements GenerateTokenService {

	public static final long TOKEN_DEFAULT_EXPIRES_IN = 3600L;
	public static final String ISSUER = "social-network-api";
	public static final String USER_ID_CLAIM = "id";
	public static final String PERSON_ID_CLAIM = "person-id";

	private final JwtEncoder jwtEncoder;

	@Override
	public String execute(User user) {
		JwtClaimsSet jwt = JwtClaimsSet.builder()
				.id(UUID.randomUUID().toString())
				.issuer(ISSUER)
				.subject(user.getUsername())
				.expiresAt(Instant.now().plusSeconds(TOKEN_DEFAULT_EXPIRES_IN))
				.issuedAt(Instant.now())
				.claim(USER_ID_CLAIM, user.getId())
				.claim(PERSON_ID_CLAIM, user.getPerson().getId())
				.build();

		return jwtEncoder.encode(JwtEncoderParameters.from(jwt))
				.getTokenValue();
	}
}
