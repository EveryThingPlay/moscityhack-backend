import com.opencsv.CSVReader;
import mch.subschool.backend.config.CsvParserConfig;
import mch.subschool.backend.model.csv.CpcAndCac;
import mch.subschool.backend.model.csv.RawClientData;
import mch.subschool.backend.service.csv.CsvParserService;

import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import mch.subschool.backend.service.csv.impl.CsvParserServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.*;
import java.util.List;

@ContextConfiguration(classes = CsvParserConfig.class)
public class CsvParserService_TestCase {

    @Autowired
    CsvParserService csvParserService;
//    @BeforeAll
//    public void setup() {
//        CsvReaderConvertingService convertingService = Mockito.mock(CsvReaderConvertingService.class);
//        csvParserService = new CsvParserServiceImpl(convertingService);
//    }

    @Test
    public void csvRawClientDataParser_test() {

        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("VM does not support mandatory encoding UTF-8");
        }

        CsvReaderConvertingService convertingService = Mockito.mock(CsvReaderConvertingService.class);
        csvParserService = new CsvParserServiceImpl(convertingService);

        List<RawClientData> rawClientData;
        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src/test/resources/ClientTransactionData.csv"));
            rawClientData = csvParserService.getRawClientDataListFromCsvReader(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------");
        for (int i = 0; i < 5; i++) {
            System.out.print(rawClientData.get(i).getClient_id() + " ");
            System.out.println(rawClientData.get(i).getCurrent_balance_sum());
        }

    }

    @Test
    public void  csvParseCpcAndCac_test(){
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("VM does not support mandatory encoding UTF-8");
        }

        CsvReaderConvertingService convertingService = Mockito.mock(CsvReaderConvertingService.class);
        csvParserService = new CsvParserServiceImpl(convertingService);
        List<CpcAndCac> cpcAndCacCollection;
        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src/test/resources/Строение данных  - СРС и САС.csv"));
            cpcAndCacCollection = csvParserService.getCpcAndCacFromCsvReader(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------");
        for (int i = 0; i < 5; i++) {
            System.out.print(cpcAndCacCollection.get(i).getCPC()+ " ");
            System.out.println(cpcAndCacCollection.get(i).getCPC());
        }
    }
}
