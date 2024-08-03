package com.invoice.payments.validations.anotations;

import com.invoice.payments.validations.validators.ValidNamePayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNamePayValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNamePay {
    String message() default "{custom.name-validation-pay.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}