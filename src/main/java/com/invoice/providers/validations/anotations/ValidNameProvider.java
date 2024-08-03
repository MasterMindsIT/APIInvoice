package com.invoice.providers.validations.anotations;

import com.invoice.providers.validations.validator.ValidNameProviderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameProviderValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameProvider {
    String message() default "{custom.name-validation-provider.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
