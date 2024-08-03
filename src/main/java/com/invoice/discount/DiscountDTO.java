package com.invoice.discount;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.discount.validations.anotations.ValidDescriptionDiscount;
import com.invoice.discount.validations.anotations.ValidNameDiscount;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal; // Cambiado de double a BigDecimal para mayor precisión
import java.time.ZonedDateTime; // Usado para fechas con información de hora

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DiscountDTO(
        Long id,
        @ValidNameDiscount String name,
        @ValidDescriptionDiscount String description,
        @Positive(message = "{custom.percentage-positive-validation-discount.message}")
        @Max(value = 100L)
        @Digits(message="{custom.percentage-validation-discount.message}", fraction = 2, integer = 3)Float percentage) {}


