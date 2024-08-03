package com.invoice.buys;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DetailBuyDTO(
        Long id,
        int quantity,
        double price,
        Long productId,
        Long buyId,
        Long brandId,
        Long categoryId
) {
}
