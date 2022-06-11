package mch.subschool.backend.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import mch.subschool.backend.model.RawClientData;
import mch.subschool.backend.service.CsvParserService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class CsvParserServiceImpl implements CsvParserService {

    public CsvParserServiceImpl() {
    }

    public List<RawClientData> parseRawClientData(String fileName) throws FileNotFoundException {
        CSVReader reader = new CSVReader(
                new FileReader(fileName));
        List<RawClientData> rawClientData = new CsvToBeanBuilder<RawClientData>(reader)
                //.withMultilineLimit(1)
                .withType(RawClientData.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                //.withThrowExceptions(true)
                .build().parse();

        return rawClientData;
    }

}
