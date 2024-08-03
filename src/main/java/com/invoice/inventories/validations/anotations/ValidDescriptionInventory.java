package com.invoice.inventories.validations.anotations;

import com.invoice.inventories.validations.validators.ValidDescriptionInventoryValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionInventoryValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionInventory {
    String message() default "{custom.description-validation-inventory.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
