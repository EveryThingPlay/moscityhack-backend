package mch.subschool.backend.model.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;
import lombok.Data;


@Data
public class AdOfferCostCsvData implements CsvData {
    @CsvBindByName(column = "Канал")
    //@CsvBindByPosition(position = 0)
    String channel;
    @CsvBindByName(column = "Компания ")
    //@CsvBindByPosition(position = 1)
    //@CsvDate("yyyy-MM-dd")
    String company;
    @CsvBindByName(column = "Предложение")
    //@CsvBindByPosition(position = 2)
    //@CsvNumber(value = "#0")
    String adOffer;

    @CsvBindByName(column = "Охват")
    //@CsvBindByPosition(position = 3)
    @CsvNumber("#0")
    Integer coverage;

    @CsvBindByName(column = "Взаимодействия")
    //@CsvBindByPosition(position = 4)
    @CsvNumber("#0")
    Integer interaction;

    @CsvBindByName(column ="Стоимость взаимодействия")
    //@CsvBindByPosition(position = 5)
    @CsvNumber(value = "#0", profiles = "variant4")
    @CsvNumber(value = "#0.0", profiles = "variant3")
    @CsvNumber(value = "\"#0,0#\"", profiles = "variant2")
    @CsvNumber(value = "-", profiles = "variant1")
    Float interactionCost;

}
