package com.invoice.providers.validations.validator;

import com.invoice.providers.validations.anotations.ValidNameProvider;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameProviderValidator implements ConstraintValidator<ValidNameProvider, String> {
    @Override
    public void initialize(ValidNameProvider constraintAnnotation) {
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
