package com.invoice.providers.validations.anotations;

import com.invoice.providers.validations.validator.ValidPhoneProviderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPhoneProviderValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidPhoneProvider {
    String message() default "{custom.phone-validation-provider.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
