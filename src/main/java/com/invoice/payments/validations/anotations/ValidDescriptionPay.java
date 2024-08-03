package com.invoice.payments.validations.anotations;

import com.invoice.payments.validations.validators.ValidDescriptionPayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionPayValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionPay {
    String message() default "{custom.description-validation-pay.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}