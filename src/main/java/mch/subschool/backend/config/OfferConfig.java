package mch.subschool.backend.config;

import mch.subschool.backend.repository.AdOfferRepository;
import mch.subschool.backend.service.AdOfferService;
import mch.subschool.backend.service.impl.AdOfferServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfig {
    @Bean
    AdOfferService adOfferService(AdOfferRepository adOfferRepository) {
        return new AdOfferServiceImpl(adOfferRepository);
    }
}
