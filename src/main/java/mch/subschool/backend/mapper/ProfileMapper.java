package mch.subschool.backend.mapper;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.dto.ProfileDto;
import mch.subschool.backend.dto.SignUpDto;

public interface ProfileMapper {
    ProfileDto toDto(Profile profile);
    Profile fromDto(ProfileDto profileDto);
    Profile fromSignUpDto(SignUpDto signUpDto);
}
