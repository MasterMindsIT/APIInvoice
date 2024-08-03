package com.invoice.providers.validations.anotations;

import com.invoice.providers.validations.validator.ValidContactProviderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidContactProviderValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidContactProvider {
    String message() default "{custom.contact-validation-provider.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
