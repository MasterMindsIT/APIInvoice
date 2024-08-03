package com.invoice.providers.validations.validator;

import com.invoice.providers.validations.anotations.ValidContactProvider;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidContactProviderValidator implements ConstraintValidator<ValidContactProvider, String> {
    @Override
    public void initialize(ValidContactProvider constraintAnnotation) {
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

        if(value.length() > 50){
            return false;
        }

        if(value.length() < 2){
            return false;
        }
        return true;
    }
}
