package com.invoice.roles.mappers;

import com.invoice.roles.RoleDTO;
import com.invoice.roles.models.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleDTO roleToRoleDTO(Roles roles);
    Roles roleDTOToRole(RoleDTO roleDTO);
}
