package com.invoice.roles;


import java.util.List;

public interface RoleExternalAPI {
    RoleDTO getRoleById(Long id);
    List<RoleDTO> getAllRole();
    RoleDTO saveRole(RoleDTO roleDTO);

    RoleDTO updateRole(Long id, RoleDTO roleDTO);

    RoleDTO deleteRole(Long id);
}
