package mch.subschool.backend.service.csv.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.csv.CsvType;
import mch.subschool.backend.model.RawClientData;
import mch.subschool.backend.service.csv.CsvParserService;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class CsvRawClientDataParserServiceImpl implements CsvParserService<RawClientData> {
    private final CsvReaderConvertingService convertingService;


    @Override
    public List<RawClientData> parseCsvByFile(MultipartFile multipartFile) throws IOException {
        CSVReader reader = convertingService.convertMultipartFile(multipartFile);

        return parseCsvByReader(reader);
    }

    @Override
    public List<RawClientData> parseCsvByReader(CSVReader csvReader) {
        return new CsvToBeanBuilder<RawClientData>(csvReader)
                //.withMultilineLimit(1)
                .withType(RawClientData.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                //.withThrowExceptions(true)
                .build().parse();
    }

    @Override
    public CsvType getCsvType() {
        return CsvType.CLIENT_DATA;
    }
}
