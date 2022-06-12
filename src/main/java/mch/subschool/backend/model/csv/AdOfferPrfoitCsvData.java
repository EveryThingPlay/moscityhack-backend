package mch.subschool.backend.model.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvNumber;
import lombok.Data;

@Data
public class AdOfferPrfoitCsvData implements CsvData {
    @CsvBindByName(column = "Канал", locale = "ru-Ru")
    String channel;
    @CsvBindByName(column = "Компания", locale = "ru-Ru")
    //@CsvDate("yyyy-MM-dd")
    String company;
    @CsvBindByName(column = "Охват", locale = "ru-Ru")
    @CsvNumber(value = "#0")
    Integer adOffer;

    @CsvBindByName(column = "Стоимость взаимодействия", locale = "ru-Ru")
    @CsvNumber(value = "#0")
    Integer interactionCount;

    @CsvBindByName(column = "Стоимость взаимодействия", locale = "ru-Ru")
    @CsvNumber(value = "#0.0", profiles = "variant1")
    @CsvNumber(value = "-", profiles = "variant2")
    Float interactionCost;


}
