package mch.subschool.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.dto.LogInDto;
import mch.subschool.backend.repository.ProfileRepository;
import mch.subschool.backend.service.LogInService;

import java.util.Optional;

@RequiredArgsConstructor
public class LogInServiceImpl implements LogInService {
    private final ProfileRepository profileRepository;

    @Override
    public String logIn(LogInDto logInDto) {
        Optional<Profile> profileOptional =
                profileRepository.getByLoginAndPassword(logInDto.getLogin(), logInDto.getPassword());
        if (profileOptional.isPresent()) {
            return profileOptional.get().getToken();
        }

        throw new IllegalStateException("Log In fail!");
    }
}
