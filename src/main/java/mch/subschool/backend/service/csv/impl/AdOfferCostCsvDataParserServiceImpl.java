package mch.subschool.backend.service.csv.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import mch.subschool.backend.model.csv.AdOfferCostCsvData;
import mch.subschool.backend.service.csv.CsvParserService;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class AdOfferCostCsvDataParserServiceImpl implements CsvParserService<AdOfferCostCsvData> {
    private final CsvReaderConvertingService convertingService;

    @Override
    public List<AdOfferCostCsvData> parseCsvByFile(MultipartFile multipartFile) throws IOException {
        CSVReader reader = convertingService.convertMultipartFile(multipartFile);

        return parseCsvByReader(reader);
    }

    @Override
    public List<AdOfferCostCsvData> parseCsvByReader(CSVReader csvReader) {
        return new CsvToBeanBuilder<AdOfferCostCsvData>(csvReader)
                //.withMultilineLimit(1)
                .withType(AdOfferCostCsvData.class)
                .withSeparator(',')
                //.withSkipLines(1)
                .withProfile("variant1")
                .withProfile("variant2")
                .withProfile("variant3")
                .withProfile("variant4")
                .withIgnoreLeadingWhiteSpace(true)
                //.withThrowExceptions(true)
                .build().parse();
    }
}


