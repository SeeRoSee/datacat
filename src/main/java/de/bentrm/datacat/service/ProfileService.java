package de.bentrm.datacat.service;

import de.bentrm.datacat.service.dto.ProfileDto;
import de.bentrm.datacat.service.dto.ProfileUpdateDto;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;

public interface ProfileService {

    @PreAuthorize("isAuthenticated()")
    ProfileDto getProfile();

    @PreAuthorize("#dto.username.equals(principal) or hasRole('ADMIN')")
    ProfileDto updateAccount(@Valid ProfileUpdateDto dto);

}
