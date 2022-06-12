package mch.subschool.backend.mapper;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.dto.ProfileDto;
import mch.subschool.backend.dto.SignUpDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DashboardMapper.class})
public interface ProfileMapper {
    @Mapping(target = "dashboardDto", source = "dashboardModel")
    @Mapping(target = "profileCommonInfo", source = "profileCommonInfo")
    @Mapping(target = "profileAdditiveInfo", source = "profileAdditiveInfo")
    @Mapping(target = "profileType", source = "profileType")
    ProfileDto toDto(Profile profile);

    @Mapping(target = "dashboardModel", source = "dashboardDto")
    @Mapping(target = "profileCommonInfo", source = "profileCommonInfo")
    @Mapping(target = "profileAdditiveInfo", source = "profileAdditiveInfo")
    @Mapping(target = "profileType", source = "profileType")
    Profile fromDto(ProfileDto profileDto);

    @Mapping(target = "profileCommonInfo", source = "profileCommonInfo")
    @Mapping(target = "profileType", source = "profileType")
    Profile fromSignUpDto(SignUpDto signUpDto);
}
