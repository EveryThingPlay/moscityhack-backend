package mch.subschool.backend.config;

import mch.subschool.backend.repository.ProfileRepository;
import mch.subschool.backend.service.LogInService;
import mch.subschool.backend.service.ProfileService;
import mch.subschool.backend.service.TokenService;
import mch.subschool.backend.service.impl.LogInServiceImpl;
import mch.subschool.backend.service.impl.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean
    LogInService logInService(ProfileRepository profileRepository) {
        return new LogInServiceImpl(profileRepository);
    }

    @Bean
    TokenService tokenService(ProfileService profileService) {
        return new TokenServiceImpl(profileService);
    }
}
