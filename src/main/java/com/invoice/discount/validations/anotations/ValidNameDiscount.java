package com.invoice.discount.validations.anotations;

import com.invoice.discount.validations.validator.ValidDescriptionDiscountValidator;
import com.invoice.discount.validations.validator.ValidNameDiscountValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameDiscountValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameDiscount {
    String message() default "{custom.name-validation-discount.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
