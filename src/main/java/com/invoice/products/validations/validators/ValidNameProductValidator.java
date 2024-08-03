package com.invoice.products.validations.validators;

import com.invoice.products.validations.anotations.ValidNameProduct;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameProductValidator implements ConstraintValidator<ValidNameProduct, String> {

    @Override
    public void initialize(ValidNameProduct constraintAnnotation) {
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

        if(value.length() > 90){
            return false;
        }

        if(value.length() < 8){
            return false;
        }
        return true;
    }
}
