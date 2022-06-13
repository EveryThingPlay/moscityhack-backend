import com.opencsv.CSVReader;
import mch.subschool.backend.config.CsvParserConfig;
import mch.subschool.backend.model.RawClientData;
import mch.subschool.backend.model.csv.AdOfferCostCsvData;
import mch.subschool.backend.model.csv.AdOfferProfitCsvData;
import mch.subschool.backend.model.csv.CpcAndCac;
import mch.subschool.backend.service.csv.CsvParserService;

import mch.subschool.backend.service.csv.CsvReaderConvertingService;
import mch.subschool.backend.service.csv.impl.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.*;
import java.util.List;

@ContextConfiguration(classes = CsvParserConfig.class)
public class CsvParserService_TestCase {


    @Test
    public void csvRawClientDataParser_test() {

        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("VM does not support mandatory encoding UTF-8");
        }

        CsvReaderConvertingService convertingService = Mockito.mock(CsvReaderConvertingService.class);
        CsvParserService<RawClientData> csvParserService = new CsvRawClientDataParserServiceImpl(convertingService);

        List<RawClientData> rawClientData;
        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src/test/resources/ClientTransactionData.csv"));
            rawClientData = csvParserService.parseCsvByReader(reader);
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
        CsvCpcAndCacParserServiceImpl csvParserService = new CsvCpcAndCacParserServiceImpl(convertingService);
        List<CpcAndCac> cpcAndCacCollection;
        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src/test/resources/Строение данных  - СРС и САС.csv"));
            cpcAndCacCollection = csvParserService.parseCsvByReader(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------");
        for (int i = 0; i < 5; i++) {
            System.out.print(cpcAndCacCollection.get(i).getCPC()+ " ");
            System.out.println(cpcAndCacCollection.get(i).getCPC());
        }
    }

    @Test
    public void  csvParseAdOfferCost_test(){
//        try {
//            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            throw new InternalError("VM does not support mandatory encoding UTF-8");
//        }

        CsvReaderConvertingService convertingService = Mockito.mock(CsvReaderConvertingService.class);
        AdOfferCostCsvDataParserServiceImpl csvParserService= new AdOfferCostCsvDataParserServiceImpl(convertingService);
        List<AdOfferCostCsvData> adOfferCostCsvData;
        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src/test/resources/Строение_данных_Пример_загрузки_подготовленной_инфы_из_канала.csv"));
            adOfferCostCsvData = csvParserService.parseCsvByReader(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------");
        for (int i = 0; i < 5; i++) {
            System.out.print(adOfferCostCsvData.get(i).getChannel()+ " ");
            System.out.println(adOfferCostCsvData.get(i).getInteraction());
        }
    }

    @Test
    public void  csvParseAdOfferProfit_test(){
//        try {
//            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            throw new InternalError("VM does not support mandatory encoding UTF-8");
//        }

        CsvReaderConvertingService convertingService = Mockito.mock(CsvReaderConvertingService.class);
        CsvParserService<AdOfferProfitCsvData> csvParserService= new AdOfferProfitCsvDataParserServiceImpl(convertingService);
        List<AdOfferProfitCsvData> adOfferProfitCsvData;
        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src/test/resources/" +
                            "Строение_данных_Пример_загрузки_подготовленной_инфы_по_продажам.csv"));
            adOfferProfitCsvData = csvParserService.parseCsvByReader(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------");

        for (int i = 0; i < 5; i++) {
            System.out.print(adOfferProfitCsvData.get(i).getChannel()+ " ");
            System.out.print(adOfferProfitCsvData.get(i).getAdOffer()+ " ");
            System.out.println(adOfferProfitCsvData.get(i).getAverageActualBalanceSum());

        }
    }
}
