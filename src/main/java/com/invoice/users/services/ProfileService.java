package com.invoice.users.services;

import com.invoice.users.ProfileDTO;
import com.invoice.users.ProfileExternalAPI;
import com.invoice.users.exceptions.ProfileNotFoundException;
import com.invoice.users.mappers.ProfileMapper;
import com.invoice.users.models.Profile;
import com.invoice.users.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService implements ProfileExternalAPI {
    private ProfileRepository profileRepository;
    private ProfileMapper profileMapper;
    @Override
    public ProfileDTO getProfileById(Long id) {
        return profileMapper.profileToProfileDTO(profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new));
    }

    @Override
    public ProfileDTO saveProfile(ProfileDTO profileDTO) {
        return profileMapper.profileToProfileDTO(profileRepository.save(profileMapper.profileDTOToProfile(profileDTO)));
    }

    @Override
    public ProfileDTO updateProfile(Long id, ProfileDTO profileDTO) {
        Profile profile = profileMapper.profileDTOToProfile(getProfileById(id));
        profile.setName(profileDTO.name());
        profile.setLast_name(profileDTO.last_name());
        profile.setAddress(profileDTO.address());
        return profileMapper.profileToProfileDTO(profileRepository.save(profile));
    }

    @Override
    public ProfileDTO deleteProfile(Long id) {
        Profile profile = profileMapper.profileDTOToProfile(getProfileById(id));
        ProfileDTO profileDTO = profileMapper.profileToProfileDTO(profile);
        profileRepository.delete(profile);
        return profileDTO;
    }
}
