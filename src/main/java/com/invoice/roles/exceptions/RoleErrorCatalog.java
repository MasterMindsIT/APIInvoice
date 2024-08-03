package com.invoice.roles.exceptions;

import lombok.Getter;

@Getter
public enum RoleErrorCatalog {
    ROLES_NOT_FOUND("ERR_ROLES_001", "Role not found."),
    INVALID_ROLES("ERR_ROLES_002", "Invalid role parameters."),
    GENERIC_ROLES_ERROR("ERR_ROLES_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    RoleErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
