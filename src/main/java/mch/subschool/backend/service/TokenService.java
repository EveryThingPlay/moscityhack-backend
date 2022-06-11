package mch.subschool.backend.service;

import mch.subschool.backend.common.ProtectedWebResource;
import mch.subschool.backend.common.profile.Profile;

public interface TokenService {
    boolean isTokenAdmittedForResource(String token, ProtectedWebResource resource);
}
