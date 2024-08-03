package com.invoice.users.mappers;

import com.invoice.users.models.Profile;
import com.invoice.users.ProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);
    ProfileDTO profileToProfileDTO(Profile profile);
    Profile profileDTOToProfile(ProfileDTO profileDTO);
}
