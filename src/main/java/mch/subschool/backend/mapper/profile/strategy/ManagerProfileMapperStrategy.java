package mch.subschool.backend.mapper.profile.strategy;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.ManagerProfileDto;
import mch.subschool.backend.dto.ProfileDto;
import mch.subschool.backend.dto.SignUpDto;
import mch.subschool.backend.mapper.DashboardMapper;
import mch.subschool.backend.mapper.ProfileMapperStrategy;
import mch.subschool.backend.model.profile.manager.ManagerProfile;

@RequiredArgsConstructor
public class ManagerProfileMapperStrategy implements ProfileMapperStrategy {
    private final DashboardMapper dashboardMapper;

    @Override
    public ProfileDto toDto(Profile profile) {
        ManagerProfileDto managerProfileDto = new ManagerProfileDto();

        managerProfileDto.setDashboardDto(dashboardMapper.toDto(profile.getDashboardModel()));
        managerProfileDto.setProfileType(profile.getProfileType());
        managerProfileDto.setProfileCommonInfo(profile.getProfileCommonInfo());

        return managerProfileDto;
    }

    @Override
    public Profile fromDto(ProfileDto profileDto) {
        ManagerProfile managerProfile = new ManagerProfile();

        managerProfile.setDashboardModel(dashboardMapper.fromDto(profileDto.getDashboardDto()));
        managerProfile.setProfileType(profileDto.getProfileType());
        managerProfile.setProfileCommonInfo(profileDto.getProfileCommonInfo());

        return managerProfile;
    }

    @Override
    public Profile fromSignUpDto(SignUpDto signUpDto) {
        return null;
    }

    @Override
    public ProfileType getProfileType() {
        return ProfileType.MANAGER;
    }
}
