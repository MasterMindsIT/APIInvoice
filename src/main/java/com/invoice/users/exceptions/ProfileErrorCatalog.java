package com.invoice.users.exceptions;

import lombok.Getter;

@Getter
public enum ProfileErrorCatalog {
    PROFILE_NOT_FOUND("ERR_PROFILE_001", "Profile not found"),
    INVALID_PROFILE("ERR_PROFILE_002", "Invalid Profile parameters."),
    GENERIC_PROFILE_ERROR("ERR_PROFILE_GENERIC_001", "An unexpected error ocurrend.");

    private final String code;
    private final String message;
    ProfileErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
