package com.invoice.taxes.validations.validators;

import com.invoice.taxes.validations.anotations.ValidDescriptionTaxes;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionTaxesValidator implements ConstraintValidator<ValidDescriptionTaxes, String> {
    @Override
    public void initialize(ValidDescriptionTaxes constraintAnnotation) {
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
