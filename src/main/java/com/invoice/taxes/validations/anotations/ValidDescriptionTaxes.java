package com.invoice.taxes.validations.anotations;

import com.invoice.taxes.validations.validators.ValidDescriptionTaxesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionTaxesValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionTaxes {
    String message() default "{custom.description-validation-taxes.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
