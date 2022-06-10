package mch.subschool.backend.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

/**
 * Модель отображения на дашборде
 */
@Data
public class DashboardModel {
    @Id
    private String id;

    /**
     * Список каналов
     */
    private List<DashboardChannel> channelList;
}
