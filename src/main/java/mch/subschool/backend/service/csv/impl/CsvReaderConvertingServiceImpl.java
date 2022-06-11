package mch.subschool.backend.service.csv.impl;

import com.opencsv.CSVReader;
import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class CsvReaderConvertingServiceImpl implements CsvReaderConvertingService {
    @Override
    public CSVReader convertMultipartFile(MultipartFile multipartFile) throws IOException {
        Reader reader = new InputStreamReader(multipartFile.getInputStream());

        return new CSVReader(reader);
    }
}
