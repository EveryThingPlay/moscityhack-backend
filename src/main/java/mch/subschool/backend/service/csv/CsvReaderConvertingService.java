package mch.subschool.backend.service.csv;

import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CsvReaderConvertingService {
    CSVReader convertMultipartFile(MultipartFile multipartFile) throws IOException;
}
