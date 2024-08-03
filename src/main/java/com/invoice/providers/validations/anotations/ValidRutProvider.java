package com.invoice.providers.validations.anotations;

import com.invoice.providers.validations.validator.ValidRutProviderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidRutProviderValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidRutProvider {
    String message() default "{custom.rut-validation-provider.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
