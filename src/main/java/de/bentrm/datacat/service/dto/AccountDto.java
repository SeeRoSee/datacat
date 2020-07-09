package de.bentrm.datacat.service.dto;

import de.bentrm.datacat.service.AccountStatus;
import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class AccountDto {
    String username;
    Instant created;
    Instant lastModified;
    boolean expired;
    boolean locked;
    boolean credentialsExpired;
    boolean emailConfirmed;
    boolean enabled;
    AccountStatus status;
    ProfileDto profile;
}
