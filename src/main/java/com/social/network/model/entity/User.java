package com.social.network.model.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import java.util.Objects;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private Person person;

	@Column(nullable = false, length = 50)
	private String username;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String passwordHash;

	@UpdateTimestamp
	@Column(nullable = false)
	private Instant updatedAt;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Instant createdAt;

	private Instant deletedAt;

	@Builder
	public User(String username, String email, String passwordHash) {
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
	}

	public boolean isDeleted() {
		return Objects.nonNull(deletedAt);
	}

	public void delete() {
		if (!isDeleted()) {
			this.deletedAt = Instant.now();
		}
	}
}