package mch.subschool.backend.config;

import mch.subschool.backend.repository.ProfileRepository;
import mch.subschool.backend.service.ProfileDashboardService;
import mch.subschool.backend.service.ProfileService;
import mch.subschool.backend.service.impl.ProfileDashboardServiceImpl;
import mch.subschool.backend.service.impl.ProfileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfig {
    @Bean
    ProfileService profileService(ProfileRepository profileRepository) {
        return new ProfileServiceImpl(profileRepository);
    }

    @Bean
    ProfileDashboardService profileDashboardService(ProfileService profileService) {
        return new ProfileDashboardServiceImpl(profileService);
    }
}
