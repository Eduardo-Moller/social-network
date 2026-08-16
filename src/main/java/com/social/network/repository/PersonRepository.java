package com.social.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.network.model.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
