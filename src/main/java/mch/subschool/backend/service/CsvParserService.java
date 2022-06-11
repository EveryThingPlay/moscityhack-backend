package mch.subschool.backend.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import mch.subschool.backend.model.RawClientData;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvParserService {

    public List<RawClientData> parseRawClientData(String fileName) throws FileNotFoundException {
        CSVReader reader = new CSVReader(
                new FileReader(fileName));
        List<RawClientData> rawClientData = new CsvToBeanBuilder<RawClientData>(reader)
                .withSeparator(',')
                .withThrowExceptions(true)
                .build().parse();

        return rawClientData;
    }

}
