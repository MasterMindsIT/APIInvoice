package com.invoice.discount.validations.validator;

import com.invoice.discount.validations.anotations.ValidDescriptionDiscount;
import com.invoice.discount.validations.anotations.ValidNameDiscount;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionDiscountValidator implements ConstraintValidator<ValidDescriptionDiscount, String> {
    @Override
    public void initialize(ValidDescriptionDiscount constraintAnnotation) {
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
