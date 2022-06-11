package mch.subschool.backend.mapper.profile.strategy;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.ProfileDto;
import mch.subschool.backend.dto.PublisherProfileDto;
import mch.subschool.backend.dto.SignUpDto;
import mch.subschool.backend.mapper.DashboardMapper;
import mch.subschool.backend.mapper.ProfileMapperStrategy;
import mch.subschool.backend.model.profile.publisher.PublisherProfile;

@RequiredArgsConstructor
public class PublisherProfileMapperStrategy implements ProfileMapperStrategy {
    private final DashboardMapper dashboardMapper;

    @Override
    public ProfileDto toDto(Profile profile) {
        PublisherProfileDto publisherProfileDto = new PublisherProfileDto();

        publisherProfileDto.setDashboardDto(dashboardMapper.toDto(profile.getDashboardModel()));
        publisherProfileDto.setProfileType(profile.getProfileType());
        publisherProfileDto.setProfileCommonInfo(profile.getProfileCommonInfo());
        publisherProfileDto.setProfileAdditiveInfo(profile.getProfileAdditiveInfo());

        return publisherProfileDto;
    }

    @Override
    public Profile fromDto(ProfileDto profileDto) {
        PublisherProfile publisherProfile = new PublisherProfile();

        publisherProfile.setDashboardModel(dashboardMapper.fromDto(profileDto.getDashboardDto()));
        publisherProfile.setProfileType(profileDto.getProfileType());
        publisherProfile.setProfileCommonInfo(profileDto.getProfileCommonInfo());
        publisherProfile.setProfileAdditiveInfo(profileDto.getProfileAdditiveInfo());

        return publisherProfile;
    }

    @Override
    public Profile fromSignUpDto(SignUpDto signUpDto) {
        return null;
    }

    @Override
    public ProfileType getProfileType() {
        return ProfileType.PUBLISHER;
    }
}
