package com.invoice.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.roles.RoleDTO;
import com.invoice.users.validations.anotations.user.ValidEmailUser;
import com.invoice.users.validations.anotations.user.ValidPasswordUser;
import com.invoice.users.validations.anotations.user.ValidUsernameUser;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDTO(
        Long id,
        @ValidUsernameUser String username,
        @ValidEmailUser String email,
        @ValidPasswordUser String password,
        Set<RoleDTO> roles ) {}
