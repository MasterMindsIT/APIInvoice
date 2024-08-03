package com.invoice.buys.validations.anotations;


import com.invoice.buys.validations.validators.ValidNoteBuyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNoteBuyValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNoteBuy {
    String message() default "{custom.note-validation-buy.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}