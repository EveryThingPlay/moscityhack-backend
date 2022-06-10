package mch.subschool.backend.config;

import mch.subschool.backend.dto.DashboardDto;
import mch.subschool.backend.mapper.DashboardMapper;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.repository.DashboardRepository;
import mch.subschool.backend.service.DashboardService;
import mch.subschool.backend.service.MapperService;
import mch.subschool.backend.service.impl.DashboardMapperService;
import mch.subschool.backend.service.impl.DashboardServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DashboardConfig {
    @Bean
    DashboardService dashboardService(DashboardRepository repository) {
        return new DashboardServiceImpl(repository);
    }

    @Bean
    MapperService<DashboardDto, DashboardModel> dashboardMapperService(DashboardMapper mapper) {
        return new DashboardMapperService(mapper);
    }
}
