package mch.subschool.backend.service.csv.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.csv.CsvType;
import mch.subschool.backend.model.csv.CpcAndCac;
import mch.subschool.backend.service.csv.CsvParserService;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class CsvCpcAndCacParserServiceImpl implements CsvParserService<CpcAndCac> {
    private final CsvReaderConvertingService convertingService;

    @Override
    public List<CpcAndCac> parseCsvByFile(MultipartFile multipartFile) throws IOException {
        CSVReader reader = convertingService.convertMultipartFile(multipartFile);

        return parseCsvByReader(reader);
    }

    @Override
    public List<CpcAndCac> parseCsvByReader(CSVReader csvReader) {
        return new CsvToBeanBuilder<CpcAndCac>(csvReader)
                //.withMultilineLimit(1)
                .withType(CpcAndCac.class)
                .withSeparator(',')
                .withProfile("variant1")
                .withProfile("variant2")
                .withProfile("variant3")
                .withIgnoreLeadingWhiteSpace(true)
                //.withThrowExceptions(true)
                .build().parse();
    }

    @Override
    public CsvType getCsvType() {
        return CsvType.CPC_AND_CAC;
    }
}
