package com.invoice.payments.exceptions;

import lombok.Getter;

@Getter
public enum PayErrorCatalog {
    PAY_NOT_FOUND("ERR_PAY_001", "Pay not found."),
    PAY_INVOICE_NOT_FOUND("ERR_PAY_INVOICE_001", "Pay Invoice not found."),
    INVALID_PAY("ERR_PAY_002", "Invalid pay parameters."),
    INVALID_PAY_INVOICE("ERR_PAY_INVOICE_002", "Invalid pay invoice parameters."),
    GENERIC_PAY_ERROR("ERR_PAY_GENERIC_001", "An unexpected error occurred."),
    GENERIC_PAY_INVOICE_ERROR("ERR_PAY_INVOICE_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;

    PayErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
