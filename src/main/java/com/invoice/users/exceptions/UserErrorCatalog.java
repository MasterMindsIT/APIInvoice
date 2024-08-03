package com.invoice.users.exceptions;

import lombok.Getter;

@Getter
public enum UserErrorCatalog {
    USER_NOT_FOUND("ERR_USER_001", "User not found"),
    INVALID_USER("ERR_USER_002", "Invalid User parameters."),
    GENERIC_USER_ERROR("ERR_USER_GENERIC_001", "An unexpected error ocurrend.");

    private final String code;
    private final String message;
    UserErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
