package mch.subschool.backend.config;

import mch.subschool.backend.repository.DashboardRepository;
import mch.subschool.backend.repository.ProfileRepository;
import mch.subschool.backend.repository.mongo.MongoDashboardRepository;
import mch.subschool.backend.repository.mongo.MongoProfileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class RepositoryConfig {
    @Bean
    DashboardRepository mongoRepository(MongoTemplate mongoTemplate) {
        return new MongoDashboardRepository(mongoTemplate);
    }

    @Bean
    ProfileRepository mongoProfileRepository(MongoTemplate mongoTemplate) {
        return new MongoProfileRepository(mongoTemplate);
    }
}
