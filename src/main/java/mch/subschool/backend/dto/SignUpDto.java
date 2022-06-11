package mch.subschool.backend.dto;

import lombok.Data;
import mch.subschool.backend.common.profile.ProfileCommonInfo;
import mch.subschool.backend.common.profile.ProfileType;

@Data
public class SignUpDto {
    private ProfileCommonInfo profileCommonInfo;
    private ProfileType profileType;
}
