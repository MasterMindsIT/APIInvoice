package com.invoice.providers.validations.validator;

import com.invoice.providers.validations.anotations.ValidRutProvider;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidRutProviderValidator implements ConstraintValidator<ValidRutProvider, String> {
    @Override
    public void initialize(ValidRutProvider constraintAnnotation) {
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

        if(value.length() > 15){
            return false;
        }

        if(value.length() < 8){
            return false;
        }
        return true;
    }

}
