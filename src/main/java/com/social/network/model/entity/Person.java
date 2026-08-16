package com.social.network.model.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "app_user_id", nullable = false, unique = true)
	private User user;

	@Column(nullable = false, length = 100)
	private String firstName;

	@Column(nullable = false, length = 100)
	private String lastName;

	@Column(nullable = false)
	private LocalDate birthDate;

	@Column(length = 500)
	private String bio;

	@Column(length = 512)
	private String avatarUrl;

	@UpdateTimestamp
	@Column(nullable = false)
	private Instant updatedAt;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Instant createdAt;

	@Builder
	public Person(
			User user,
			String firstName,
			String lastName,
			LocalDate birthDate,
			String bio,
			String avatarUrl
	) {
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.bio = bio;
		this.avatarUrl = avatarUrl;
	}
}
