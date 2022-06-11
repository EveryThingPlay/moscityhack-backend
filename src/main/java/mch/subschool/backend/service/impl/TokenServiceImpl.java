package mch.subschool.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.ProtectedWebResource;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.service.ProfileService;
import mch.subschool.backend.service.TokenService;

import java.util.Base64;

@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final ProfileService profileService;

    @Override
    public boolean isTokenAdmittedForResource(String token, ProtectedWebResource resource) {
        Profile profile = profileService.getProfileByToken(token);

        return resource.getAdmittedProfileTypeList().contains(profile.getProfileType());
    }
}
