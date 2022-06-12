package mch.subschool.backend.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class RawChannelData {
    @CsvBindByName(column = "Канал")
    private String channel;

    @CsvBindByName(column = "Компания ")
    private String campaign;

    @CsvBindByName(column = "Предложение")
    private String offer;

    @CsvBindByName(column = "Охват")
    private String audienceReach;

    @CsvBindByName(column = "Взаимодействия")
    private String interactionCount;

    @CsvBindByName(column = "Стоимость взаимодействия")
    private String interactionPrice;
}
