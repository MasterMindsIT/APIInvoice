package com.invoice.users.validations.anotations.profile;

import com.invoice.users.validations.validators.profile.ValidNameProfileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameProfileValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameProfile {
    String message() default "{custom.name-validation-profile.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}