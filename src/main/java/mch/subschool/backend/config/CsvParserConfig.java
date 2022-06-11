package mch.subschool.backend.config;

import mch.subschool.backend.service.CsvParserService;
import mch.subschool.backend.service.impl.CsvParserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvParserConfig {

    @Bean
    CsvParserService csvParserService() {
        return new CsvParserServiceImpl();
    }
}

