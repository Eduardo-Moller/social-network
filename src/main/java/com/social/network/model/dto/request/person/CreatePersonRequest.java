package com.social.network.model.dto.request.person;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.social.network.validation.annotation.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequest {
	@NotBlank(message = "primeiro nome não pode ser nulo e ou vazio")
	@Size(min = 3, max = 100, message = "primeiro nome deve ter entre 3 e 100 caracteres")
	private String firstName;

	@NotBlank(message = "ultimo nome não pode ser nulo e ou vazio")
	@Size(min = 3, max = 100, message = "ultimo nome deve ter entre 3 e 100 caracteres")
	private String lastName;

	@NotBlank(message = "nome de usúario não pode ser nulo e ou vazio")
	@Size(min = 3, max = 50, message = "nome de usúario deve ter entre 3 e 50 caracteres")
	private String username;

	@NotBlank(message = "email não pode ser nulo e ou vazio")
	@Size(max = 255, message = "email deve ter no máximo 255 caracteres")
	@Email(message = "email deve ser um email válido")
	private String email;

	@NotNull(message = "data de nascimento não pode ser nulo")
	@Past(message = "data de nascimento não pode ser uma data futura")
	private LocalDate birthDate;

	@NotBlank(message = "senha não pode ser nulo e ou vazio")
	@Size(min = 12, max = 255, message = "senha deve ter entre 12 e 255 caracteres")
	@StrongPassword
	private String password;
}
