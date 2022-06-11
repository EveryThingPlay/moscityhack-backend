package mch.subschool.backend.config;

import mch.subschool.backend.mapper.DashboardMapper;
import mch.subschool.backend.mapper.ProfileMapper;
import mch.subschool.backend.mapper.ProfileMapperStrategy;
import mch.subschool.backend.mapper.profile.impl.ProfileMapperImpl;
import mch.subschool.backend.mapper.profile.strategy.ManagerProfileMapperStrategy;
import mch.subschool.backend.mapper.profile.strategy.PublisherProfileMapperStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapperConfig {
    @Bean
    ProfileMapperStrategy publisherProfileMapperStrategy(DashboardMapper dashboardMapper) {
        return new PublisherProfileMapperStrategy(dashboardMapper);
    }

    @Bean
    ProfileMapperStrategy managerProfileMapperStrategy(DashboardMapper dashboardMapper) {
        return new ManagerProfileMapperStrategy(dashboardMapper);
    }

    @Bean
    ProfileMapper profileMapper(List<ProfileMapperStrategy> strategyList) {
        return new ProfileMapperImpl(strategyList);
    }
}
