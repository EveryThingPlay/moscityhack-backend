package mch.subschool.backend.config;

import mch.subschool.backend.service.csv.CsvParserService;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import mch.subschool.backend.service.csv.impl.CsvRawClientDataParserServiceImpl;
import mch.subschool.backend.service.csv.impl.CsvReaderConvertingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvParserConfig {
    @Bean
    CsvReaderConvertingService convertingService() {
        return new CsvReaderConvertingServiceImpl();
    }

//    @Bean
//    CsvParserService csvParserService(CsvReaderConvertingService convertingService) {
//        return new CsvRawClientDataParserServiceImpl(convertingService);
//    }
}

