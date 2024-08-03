package com.invoice.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.products.validations.anotations.ValidDescriptionProduct;
import com.invoice.products.validations.anotations.ValidNameProduct;
import jakarta.validation.constraints.Digits;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductsDTO (
        Long id,
        @ValidNameProduct String name,
        @ValidDescriptionProduct String description,
        //@Digits(message="${custom.price-validation-product.message}", fraction = 2, integer = 10) float price,
        Long providerId,
        Long brandId,
        Long categoryId){
}