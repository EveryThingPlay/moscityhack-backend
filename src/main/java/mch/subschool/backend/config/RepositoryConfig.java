package mch.subschool.backend.config;

import mch.subschool.backend.repository.DashboardRepository;
import mch.subschool.backend.repository.MongoDashboardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class RepositoryConfig {
    @Bean
    DashboardRepository mongoRepository(MongoTemplate mongoTemplate) {
        return new MongoDashboardRepository(mongoTemplate);
    }
}
