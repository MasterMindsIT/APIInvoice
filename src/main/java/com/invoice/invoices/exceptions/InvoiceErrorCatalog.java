package com.invoice.invoices.exceptions;

import lombok.Getter;

@Getter
public enum InvoiceErrorCatalog {
    INVOICE_NOT_FOUND("ERR_INVOICES_001", "Invoice not found."),
    INVALID_INVOICE("ERR_INVOICES_002", "Invalid invoice parameters."),
    GENERIC_INVOICE_ERROR("ERR_INVOICE_GENERIC_001", "An unexpected error ocurred.");

    private final String code;
    private final String message;


    InvoiceErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
