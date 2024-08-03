package com.invoice.taxes.validations.anotations;

import com.invoice.taxes.validations.validators.ValidNameTaxesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameTaxesValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameTaxes {
    String message() default "{custom.name-validation-taxes.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
