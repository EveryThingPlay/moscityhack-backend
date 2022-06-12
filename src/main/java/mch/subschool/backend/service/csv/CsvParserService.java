package mch.subschool.backend.service.csv;

import com.opencsv.CSVReader;
import mch.subschool.backend.model.csv.CpcAndCac;
import mch.subschool.backend.model.csv.RawClientData;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CsvParserService {

    List<RawClientData> parseRawClientData(MultipartFile multipartFile) throws IOException;

    List<CpcAndCac> parseCasAndCac(MultipartFile multipartFile)throws IOException;

    List<RawClientData> getRawClientDataListFromCsvReader(CSVReader csvReader);

    List<CpcAndCac> getCpcAndCacFromCsvReader(CSVReader csvReader);

}
