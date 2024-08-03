package com.invoice.users.validations.anotations.user;

import com.invoice.users.validations.validators.user.ValidPasswordUserValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPasswordUserValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidPasswordUser {
    String message() default "{custom.password-validation-user.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}