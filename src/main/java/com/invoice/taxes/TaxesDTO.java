package com.invoice.taxes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.taxes.validations.anotations.ValidDescriptionTaxes;
import com.invoice.taxes.validations.anotations.ValidNameTaxes;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;


public record TaxesDTO (
        @JsonInclude(JsonInclude.Include.NON_NULL) Long id,
        @ValidNameTaxes String name,
        @Positive(message = "{custom.value-positive-validation-taxes.message}")
        @Max(value = 100L, message = "{custom.value-max-validation-taxes.message}")
        @Digits(message="{custom.value-validation-taxes.message}", fraction = 2, integer = 3)
        BigDecimal value,
        @ValidDescriptionTaxes String description,
        //@Pattern(regexp = "^(true|false)$", message = "{custom.isactive-validation-taxes.message}")
        @NotNull
        Boolean isActive) {}


