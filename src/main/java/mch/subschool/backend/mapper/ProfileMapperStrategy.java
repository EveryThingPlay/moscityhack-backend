package mch.subschool.backend.mapper;

import mch.subschool.backend.common.profile.ProfileType;

public interface ProfileMapperStrategy extends ProfileMapper{
    ProfileType getProfileType();
}
