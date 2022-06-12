package mch.subschool.backend.dto;

import lombok.Data;
import mch.subschool.backend.common.profile.ProfileType;

@Data
public class LogInResponseDto {
    String token;
    ProfileType profileType;
}
