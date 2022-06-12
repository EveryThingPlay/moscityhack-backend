package mch.subschool.backend.controller;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.LogInDto;
import mch.subschool.backend.dto.LogInResponseDto;
import mch.subschool.backend.dto.SignUpDto;
import mch.subschool.backend.mapper.ProfileMapper;
import mch.subschool.backend.service.LogInService;
import mch.subschool.backend.service.ProfileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/authorization/")
@RequiredArgsConstructor
public class AuthorizationController {
    private final ProfileService profileService;
    private final ProfileMapper profileMapper;
    private final LogInService logInService;

    @PostMapping(value = "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String createProfile(@RequestBody SignUpDto signUpDto) {
        Profile profile = profileMapper.fromSignUpDto(signUpDto);

        return profileService.createProfile(profile);
    }

    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LogInResponseDto logIn(@RequestBody LogInDto logInDto) {
        String token = logInService.logIn(logInDto);
        ProfileType profileType = profileService.getProfileByToken(token).getProfileType();
        LogInResponseDto responseDto = new LogInResponseDto();
        responseDto.setToken(token);
        responseDto.setProfileType(profileType);

        return responseDto;
    }
}
