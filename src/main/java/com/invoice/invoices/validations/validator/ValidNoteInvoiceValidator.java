package com.invoice.invoices.validations.validator;

import com.invoice.invoices.validations.anotations.ValidNoteInvoice;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNoteInvoiceValidator implements ConstraintValidator<ValidNoteInvoice, String> {
    @Override
    public void initialize(ValidNoteInvoice constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return false;
        }

        if(value.isEmpty()){
            return false;
        }

        if(value.length() > 200){
            return false;
        }

        if(value.length() < 10){
            return false;
        }
        return true;
    }
}
