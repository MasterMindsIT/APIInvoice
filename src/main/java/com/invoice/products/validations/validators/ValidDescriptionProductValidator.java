package com.invoice.products.validations.validators;

import com.invoice.products.validations.anotations.ValidDescriptionProduct;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionProductValidator implements ConstraintValidator<ValidDescriptionProduct, String> {
    @Override
    public void initialize(ValidDescriptionProduct constraintAnnotation) {
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

        if(value.length() > 300){
            return false;
        }

        if(value.length() < 15){
            return false;
        }
        return true;
    }
}
