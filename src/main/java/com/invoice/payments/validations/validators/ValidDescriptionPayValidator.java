package com.invoice.payments.validations.validators;

import com.invoice.payments.validations.anotations.ValidDescriptionPay;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionPayValidator implements ConstraintValidator<ValidDescriptionPay, String> {
    @Override
    public void initialize(ValidDescriptionPay constraintAnnotation) {
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
