package com.invoice.buys.validations.validators;

import com.invoice.buys.validations.anotations.ValidNoteBuy;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNoteBuyValidator implements ConstraintValidator<ValidNoteBuy, String> {
    @Override
    public void initialize(ValidNoteBuy constraintAnnotation) {
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
