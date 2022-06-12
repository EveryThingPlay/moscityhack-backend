package mch.subschool.backend.model.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvNumber;
import lombok.Data;

@Data
public class AdOfferPrfoitCsvData implements CsvData {
    @CsvBindByName(column = "Канал", locale = "ru-Ru")
    private String channel;
    @CsvBindByName(column = "Компания", locale = "ru-Ru")
    //@CsvDate("yyyy-MM-dd")
    private String company;
    @CsvBindByName(column = "Охват", locale = "ru-Ru")
    @CsvNumber(value = "#0")
    private Integer adOffer;

    @CsvBindByName(column = "Стоимость взаимодействия", locale = "ru-Ru")
    @CsvNumber(value = "#0")
    private Integer interactionCount;

    @CsvBindByName(column = "Стоимость взаимодействия", locale = "ru-Ru")
    @CsvNumber(value = "#0.0", profiles = "variant1")
    @CsvNumber(value = "-", profiles = "variant2")
    private Float interactionCost;


}
