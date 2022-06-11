package mch.subschool.backend.service.csv;

import mch.subschool.backend.model.RawClientData;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CsvParserService {
    List<RawClientData> parseRawClientData(String path) throws FileNotFoundException;
    List<RawClientData> parseRawClientData(MultipartFile multipartFile) throws IOException;
}
