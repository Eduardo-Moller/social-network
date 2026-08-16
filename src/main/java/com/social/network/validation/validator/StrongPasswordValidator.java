package com.social.network.validation.validator;

import java.util.Objects;

import com.social.network.validation.annotation.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (Objects.isNull(password)) {
			return true;
		}

		boolean hasLowercase = false;
		boolean hasUppercase = false;
		boolean hasNumber = false;
		boolean hasSpecialCharacter = false;

		for (char character : password.toCharArray()) {
			if (Character.isLowerCase(character)) {
				hasLowercase = true;
			} else if (Character.isUpperCase(character)) {
				hasUppercase = true;
			} else if (Character.isDigit(character)) {
				hasNumber = true;
			} else if (!Character.isLetterOrDigit(character)) {
				hasSpecialCharacter = true;
			}
		}

		return hasLowercase && hasUppercase && hasNumber && hasSpecialCharacter;
	}
}
