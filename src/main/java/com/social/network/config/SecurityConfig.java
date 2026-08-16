package com.social.network.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) {
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.cors(cors -> cors.configurationSource(corsConfigurationSource))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(
								"/swagger-ui.html",
								"/swagger-ui/**",
								"/v3/api-docs",
								"/v3/api-docs/**",
								"/v3/api-docs.yaml"
						).permitAll()
						.requestMatchers(HttpMethod.POST, "/persons").permitAll()
						.anyRequest().authenticated()
				)
				.build();
	}
}
