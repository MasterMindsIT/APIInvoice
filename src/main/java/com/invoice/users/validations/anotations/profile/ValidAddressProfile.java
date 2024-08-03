package com.invoice.users.validations.anotations.profile;

import com.invoice.users.validations.validators.profile.ValidAddressProfileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidAddressProfileValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidAddressProfile {
    String message() default "{custom.address-validation-profile.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}