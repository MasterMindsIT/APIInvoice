package com.invoice.roles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.roles.models.Permissions;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RoleDTO(
        Long id,
        String name,
        Set<PermissionDTO> permissionList ) {}