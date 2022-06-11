import mch.subschool.backend.model.RawClientData;
import mch.subschool.backend.service.CsvParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.util.List;

public class CsvParserService_TestCase {

    @Test
    public void csvParserService_test() {
        CsvParserService csvParserService = new CsvParserService();
        List<RawClientData> rawClientData;
        try {
            rawClientData = csvParserService.parseRawClientData("src/test/resources/ClientTransactionData.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(rawClientData.get(i).getClient_id() + " ");
            System.out.print(rawClientData.get(i).getCurrent_balance_sum());
        }

    }


}
