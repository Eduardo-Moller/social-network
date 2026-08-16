package com.social.network.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.social.network.validation.validator.StrongPasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = StrongPasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

	String message() default "senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
