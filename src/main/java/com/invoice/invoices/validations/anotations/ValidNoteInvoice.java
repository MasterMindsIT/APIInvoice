package com.invoice.invoices.validations.anotations;


import com.invoice.invoices.validations.validator.ValidNoteInvoiceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNoteInvoiceValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNoteInvoice {
    String message() default "{custom.note-validation-invoice.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}