package com.invoice.roles.mappers;

import com.invoice.roles.PermissionDTO;
import com.invoice.roles.models.Permissions;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermisionsMapper {
    PermisionsMapper INSTANCE = Mappers.getMapper(PermisionsMapper.class);
    PermissionDTO permissionToPermissionDTO (Permissions permissions);
    Permissions permissionDTOToPermission(PermissionDTO permissionDTO);
}
