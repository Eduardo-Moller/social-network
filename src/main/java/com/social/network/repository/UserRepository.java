package com.social.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.network.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmailIgnoreCase(String email);
}
