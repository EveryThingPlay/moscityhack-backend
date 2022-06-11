package mch.subschool.backend.common;

import mch.subschool.backend.common.profile.ProfileType;

import java.util.List;

public interface ProtectedWebResource {
    List<ProfileType> getAdmittedProfileTypeList();
}

