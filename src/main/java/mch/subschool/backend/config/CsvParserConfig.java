package mch.subschool.backend.config;

import mch.subschool.backend.model.RawClientData;
import mch.subschool.backend.model.csv.CpcAndCac;
import mch.subschool.backend.service.csv.CsvParserService;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import mch.subschool.backend.service.csv.impl.CsvCpcAndCacParserServiceImpl;
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

    @Bean
    CsvParserService<RawClientData> csvRawClientDaraParserService(CsvReaderConvertingService convertingService) {
        return new CsvRawClientDataParserServiceImpl(convertingService);
    }

    @Bean
    CsvParserService<CpcAndCac> csvCpcAndCacParserService(CsvReaderConvertingService convertingService) {
        return new CsvCpcAndCacParserServiceImpl(convertingService);
    }
}

