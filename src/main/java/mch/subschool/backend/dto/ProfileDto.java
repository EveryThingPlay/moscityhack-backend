package mch.subschool.backend.dto;

import lombok.Data;
import mch.subschool.backend.common.profile.ProfileAdditiveInfo;
import mch.subschool.backend.common.profile.ProfileCommonInfo;
import mch.subschool.backend.common.profile.ProfileType;

@Data
public class ProfileDto {
    DashboardDto dashboardDto;
    ProfileCommonInfo profileCommonInfo;
    ProfileAdditiveInfo profileAdditiveInfo;
    ProfileType profileType;
}
