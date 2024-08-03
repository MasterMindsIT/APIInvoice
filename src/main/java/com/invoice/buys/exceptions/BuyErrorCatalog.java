package com.invoice.buys.exceptions;

import lombok.Getter;

@Getter
public enum BuyErrorCatalog {
    BUY_ERROR_CATALOG("ERR_BUY_001", "Buy not found."),
    INVALID_BUY("ERR_BUY_002", "Invalid Buys parameters."),
    GENERIC_BUY_ERROR("ERR_BUY_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    BuyErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
