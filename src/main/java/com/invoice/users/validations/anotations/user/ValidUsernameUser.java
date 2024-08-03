package com.invoice.users.validations.anotations.user;

import com.invoice.users.validations.validators.user.ValidUsernameUserValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidUsernameUserValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidUsernameUser {
    String message() default "{custom.username-validation-user.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}