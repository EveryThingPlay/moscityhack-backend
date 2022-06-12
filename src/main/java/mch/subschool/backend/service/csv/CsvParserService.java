package mch.subschool.backend.service.csv;

import com.opencsv.CSVReader;
import com.opencsv.ICSVParser;
import mch.subschool.backend.model.csv.CpcAndCac;
import mch.subschool.backend.model.csv.CsvData;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CsvParserService <T extends CsvData>  {

    List<T> parseCsvByFile(MultipartFile multipartFile) throws IOException;


    List<T> parseCsvByReader(CSVReader csvReader);

}

