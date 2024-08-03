package com.invoice.users.validations.anotations.user;

import com.invoice.users.validations.validators.user.ValidEmailUserValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidEmailUserValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidEmailUser {
    String message() default "{custom.email-validation-user.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}