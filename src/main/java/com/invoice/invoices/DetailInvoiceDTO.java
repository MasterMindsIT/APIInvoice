package com.invoice.invoices;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DetailInvoiceDTO(
         Long id,
         int quantity,
         double price,
         Long productId,
         Long invoiceId
) {
}
