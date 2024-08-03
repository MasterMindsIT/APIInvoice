package com.invoice.products.validations.anotations;

import com.invoice.products.validations.validators.ValidNameProductValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameProductValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameProduct {
    String message() default "{custom.name-validation-product.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
