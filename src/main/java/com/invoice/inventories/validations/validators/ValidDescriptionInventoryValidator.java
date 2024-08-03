package com.invoice.inventories.validations.validators;

import com.invoice.inventories.validations.anotations.ValidDescriptionInventory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionInventoryValidator implements ConstraintValidator<ValidDescriptionInventory, String> {
    @Override
    public void initialize(ValidDescriptionInventory constraintAnnotation) {
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

        if(value.length() < 2){
            return false;
        }
        return true;
    }
}
