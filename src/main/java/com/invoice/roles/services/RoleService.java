package com.invoice.roles.services;

import com.invoice.roles.PermissionDTO;
import com.invoice.roles.RoleDTO;
import com.invoice.roles.RoleExternalAPI;
import com.invoice.roles.exceptions.RoleNotFoundException;
import com.invoice.roles.mappers.PermisionsMapper;
import com.invoice.roles.mappers.RoleMapper;
import com.invoice.roles.models.Permissions;
import com.invoice.roles.models.RolePermission;
import com.invoice.roles.models.Roles;
import com.invoice.roles.repositories.PermissionRepository;
import com.invoice.roles.repositories.RolePermissionRepository;
import com.invoice.roles.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleService implements RoleExternalAPI {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final PermisionsMapper permisionsMapper;
    private final RolePermissionRepository rolePermissionRepository;
    @Override
    public RoleDTO getRoleById(Long id) {
                return roleMapper.roleToRoleDTO(roleRepository.findById(id).orElseThrow(RoleNotFoundException::new));
    }

    @Override
    public List<RoleDTO> getAllRole() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::roleToRoleDTO)
                .toList();
    }

    @Override
    public RoleDTO saveRole(RoleDTO roleDTO) {
        Object[] permissions = roleDTO.permissionList().stream().map(PermissionDTO::id).toArray();
        Roles rol = new Roles(null, roleDTO.name().toUpperCase(),null);
        rol = roleRepository.save(rol);
        for (Object permission : permissions) {
            rolePermissionRepository.save(new RolePermission(null,rol.getId(),(Long)permission));
        }
        return getRoleById(rol.getId());
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        Object[] permissions = roleDTO.permissionList().stream().map(PermissionDTO::id).toArray();
        Roles rol = roleMapper.roleDTOToRole(getRoleById(id));
        rol.setName(roleDTO.name().toUpperCase());
        rol = roleRepository.save(rol);
        rolePermissionRepository.deleteAllByRoleID(rol.getId());
        for (Object permission : permissions) {
            rolePermissionRepository.save(new RolePermission(null,rol.getId(),(Long)permission));
        }

        return getRoleById(id);
    }

    @Override
    public RoleDTO deleteRole(Long id) {
        Roles roles = roleMapper.roleDTOToRole(getRoleById(id));
        RoleDTO roleDTO =  roleMapper.roleToRoleDTO(roles);
        roleRepository.delete(roles);
        return roleDTO;
    }
}
