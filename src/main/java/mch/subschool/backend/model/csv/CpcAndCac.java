package mch.subschool.backend.model.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import com.opencsv.bean.CsvNumbers;
import lombok.Data;

import java.util.Date;

@Data
public class CpcAndCac {
    @CsvBindByName(column = "Канал", locale = "ru-Ru")
    String Channel;
    @CsvBindByName(column = "Дата", locale = "ru-Ru")
    //@CsvDate("yyyy-MM-dd")
    String date;
    @CsvBindByName(column = "CPC", locale = "ru-Ru")
    //@CsvNumber(value = "#0.")
    @CsvNumber(value = "#0.0", profiles = "variant1")
    @CsvNumber(value = "#0,0", profiles = "variant2")
    @CsvNumber(value = "#0", profiles = "variant3")
    Float CPC;
    @CsvBindByName(column = "Расходы", locale = "ru-Ru")
    @CsvNumber(value = "#0")
    Integer expenses;
    @CsvBindByName(column = "Продажи", locale = "ru-Ru")
    @CsvNumber(value = "#0")
    Integer sales;

}
