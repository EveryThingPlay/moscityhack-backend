package mch.subschool.backend.model.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvNumber;
import lombok.Data;

@Data
public class AdOfferProfitCsvData implements CsvData {
    @CsvBindByName(column = "Канал")
    //@CsvBindByPosition(position = 0)
    String channel;
    @CsvBindByName(column = "Компания ")
    //@CsvBindByPosition(position = 1)
    //@CsvDate("yyyy-MM-dd")
    String company;
    @CsvBindByName(column = "Предложение")
    @CsvBindByPosition(position = 2)
    //@CsvNumber(value = "#0")
    String adOffer;

    @CsvBindByName(column="Продажи")
    //@CsvBindByPosition(position = 3)
    @CsvNumber(value = "#0")
//    @CsvNumber(value = "#0", profiles = "variant1")
//    @CsvNumber(value = "#0.0", profiles = "variant2")
//    @CsvNumber(value = "#-", profiles = "variant3")
    int sales;

    @CsvBindByName(column = "Сумма контрактов")
    //@CsvBindByPosition(position = 4)
    //@CsvNumber(value = "#0")
    @CsvNumber(value = "#0", profiles = "variant1")
    @CsvNumber(value = "#0.0", profiles = "variant2")
    @CsvNumber(value = "#-", profiles = "variant3")
    Long contractSum;

    @CsvBindByName(column = "Сумма средних актуальных балансов", locale = "ru-Ru")
    //@CsvBindByPosition(position = 5)
    //@CsvNumber(value = "#0")
    @CsvNumber(value = "#0", profiles = "variant1")
    @CsvNumber(value = "#0.0", profiles = "variant2")
    @CsvNumber(value = "#-", profiles = "variant3")
    Long averageActualBalanceSum;

}
