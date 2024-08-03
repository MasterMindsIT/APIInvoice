package com.invoice.providers.validations.validator;

import com.invoice.providers.validations.anotations.ValidPhoneProvider;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhoneProviderValidator implements ConstraintValidator<ValidPhoneProvider, String> {
    @Override
    public void initialize(ValidPhoneProvider constraintAnnotation) {
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

        if(value.length() > 16){
            return false;
        }

        if(value.length() < 7){
            return false;
        }
        return true;
    }
}
