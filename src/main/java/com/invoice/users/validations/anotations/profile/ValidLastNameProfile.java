package com.invoice.users.validations.anotations.profile;

import com.invoice.users.validations.validators.profile.ValidLastNameProfileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidLastNameProfileValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidLastNameProfile {
    String message() default "{custom.last-name-validation-profile.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}