package mch.subschool.backend.mapper.profile.impl;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.ProfileDto;
import mch.subschool.backend.dto.SignUpDto;
import mch.subschool.backend.mapper.DashboardMapper;
import mch.subschool.backend.mapper.ProfileMapper;
import mch.subschool.backend.mapper.ProfileMapperStrategy;
import mch.subschool.backend.model.DashboardModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileMapperImpl implements ProfileMapper {
    private final Map<ProfileType, ProfileMapperStrategy> strategies;

    public ProfileMapperImpl(List<ProfileMapperStrategy> strategyList) {
        this.strategies = new HashMap<>();

        for (ProfileMapperStrategy strategy : strategyList) {
            strategies.put(strategy.getProfileType(), strategy);
        }
    }

    @Override
    public ProfileDto toDto(Profile profile) {
        ProfileMapperStrategy strategy = strategies.get(profile.getProfileType());

        return strategy.toDto(profile);
    }

    @Override
    public Profile fromDto(ProfileDto profileDto) {
        ProfileMapperStrategy strategy = strategies.get(profileDto.getProfileType());

        return strategy.fromDto(profileDto);
    }

    @Override
    public Profile fromSignUpDto(SignUpDto signUpDto) {
        Profile profile = new Profile();
        profile.setProfileType(signUpDto.getProfileType());
        profile.setDashboardModel(new DashboardModel());
        profile.setProfileCommonInfo(signUpDto.getProfileCommonInfo());

        return profile;
    }
}
