package com.invoice.products.validations.anotations;

import com.invoice.products.validations.validators.ValidDescriptionProductValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionProductValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionProduct {
    String message() default "{custom.description-validation-product.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
