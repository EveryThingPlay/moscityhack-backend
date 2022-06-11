package mch.subschool.backend.service.csv.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import mch.subschool.backend.model.RawClientData;
import mch.subschool.backend.service.csv.CsvParserService;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class CsvParserServiceImpl implements CsvParserService {
    private final CsvReaderConvertingService convertingService;

    public List<RawClientData> parseRawClientData(String fileName) throws FileNotFoundException {
        CSVReader reader = new CSVReader(
                new FileReader(fileName));

        return getRawClientDataListFromCsvReader(reader);
    }

    @Override
    public List<RawClientData> parseRawClientData(MultipartFile multipartFile) throws IOException {
        CSVReader reader = convertingService.convertMultipartFile(multipartFile);

        return getRawClientDataListFromCsvReader(reader);
    }

    private List<RawClientData> getRawClientDataListFromCsvReader(CSVReader csvReader) {
        return new CsvToBeanBuilder<RawClientData>(csvReader)
                //.withMultilineLimit(1)
                .withType(RawClientData.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                //.withThrowExceptions(true)
                .build().parse();
    }

}
