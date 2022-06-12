package mch.subschool.backend.service;

import mch.subschool.backend.common.ProtectedWebResource;

public interface TokenService {
    boolean isTokenAdmittedForResource(String token, ProtectedWebResource resource);
}
