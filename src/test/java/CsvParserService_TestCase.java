import mch.subschool.backend.config.CsvParserConfig;
import mch.subschool.backend.model.RawClientData;
import mch.subschool.backend.service.csv.CsvParserService;

import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import mch.subschool.backend.service.csv.impl.CsvParserServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.FileNotFoundException;
import java.util.List;

@ContextConfiguration(classes = CsvParserConfig.class)
public class CsvParserService_TestCase {

    @Autowired
    CsvParserService csvParserService;
    @Before
    public void setup() {
    }

    @Test
    public void csvParserService_test() {
        CsvReaderConvertingService convertingService = Mockito.mock(CsvReaderConvertingService.class);
        csvParserService = new CsvParserServiceImpl(convertingService);
        List<RawClientData> rawClientData;
        try {
            rawClientData = csvParserService.parseRawClientData("src/test/resources/ClientTransactionData.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------");
        for (int i = 0; i < 5; i++) {
            System.out.print(rawClientData.get(i).getClient_id() + " ");
            System.out.println(rawClientData.get(i).getCurrent_balance_sum());
        }

    }


}
