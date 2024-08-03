package com.invoice.invoices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.invoices.models.DetailInvoice;
import com.invoice.invoices.validations.anotations.ValidNoteInvoice;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record InvoiceDTO(
        Long id,
        int numberInvoice,
        double mount,
        Date day,
        Date hour,
        List<DetailInvoiceDTO> detailInvoiceDTO,
        @ValidNoteInvoice String note
) {
}
