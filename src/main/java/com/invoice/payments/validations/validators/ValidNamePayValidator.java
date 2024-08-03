package com.invoice.payments.validations.validators;

import com.invoice.payments.validations.anotations.ValidNamePay;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNamePayValidator implements ConstraintValidator<ValidNamePay, String> {
    @Override
    public void initialize(ValidNamePay constraintAnnotation) {
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

        if(value.length() > 30){
            return false;
        }

        if(value.length() < 2){
            return false;
        }
        return true;
    }
}
