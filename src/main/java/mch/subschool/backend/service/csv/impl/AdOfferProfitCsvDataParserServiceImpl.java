package mch.subschool.backend.service.csv.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;

import mch.subschool.backend.model.csv.AdOfferProfitCsvData;
import mch.subschool.backend.service.csv.CsvParserService;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class AdOfferProfitCsvDataParserServiceImpl implements CsvParserService<AdOfferProfitCsvData> {
    private final CsvReaderConvertingService convertingService;

    @Override
    public List<AdOfferProfitCsvData> parseCsvByFile(MultipartFile multipartFile) throws IOException {
        CSVReader reader = convertingService.convertMultipartFile(multipartFile);

        return parseCsvByReader(reader);
    }

    @Override
    public List<AdOfferProfitCsvData> parseCsvByReader(CSVReader csvReader) {
        return new CsvToBeanBuilder<AdOfferProfitCsvData>(csvReader)
                //.withMultilineLimit(1)
                .withType(AdOfferProfitCsvData.class)
                .withSeparator(',')
                .withProfile("variant1")
                .withProfile("variant2")
                .withProfile("variant3")
                .withIgnoreLeadingWhiteSpace(true)
                .withThrowExceptions(true)
                .build()
                .parse();
    }
}
