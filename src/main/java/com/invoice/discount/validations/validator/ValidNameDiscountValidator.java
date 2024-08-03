package com.invoice.discount.validations.validator;

import com.invoice.discount.validations.anotations.ValidNameDiscount;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameDiscountValidator implements ConstraintValidator<ValidNameDiscount, String> {
    @Override
    public void initialize(ValidNameDiscount constraintAnnotation) {
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

        if(value.length() > 20){
            return false;
        }

        if(value.length() < 2){
            return false;
        }
        return true;
    }
}
