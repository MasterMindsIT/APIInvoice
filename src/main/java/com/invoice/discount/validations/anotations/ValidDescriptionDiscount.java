package com.invoice.discount.validations.anotations;

import com.invoice.companies.validations.validator.ValidNameCompanyValidator;
import com.invoice.discount.validations.validator.ValidDescriptionDiscountValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionDiscountValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionDiscount {
    String message() default "{custom.description-validation-discount.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
