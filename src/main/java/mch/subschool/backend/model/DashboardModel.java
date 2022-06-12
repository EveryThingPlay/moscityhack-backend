package mch.subschool.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * Модель отображения на дашборде
 */
@Data
public class DashboardModel {
    /**
     * Id для выбранной БД
     */
    @Id
    private String id;

    /**
     * Список каналов
     */
    private List<DashboardChannel> channelList;
}
