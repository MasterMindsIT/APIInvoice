package com.invoice.users;

import java.util.List;

public interface ProfileExternalAPI {
    ProfileDTO getProfileById(Long id);
    ProfileDTO saveProfile(ProfileDTO profileDTO);
    ProfileDTO updateProfile(Long id, ProfileDTO profileDTO);
    ProfileDTO deleteProfile(Long id);
}
