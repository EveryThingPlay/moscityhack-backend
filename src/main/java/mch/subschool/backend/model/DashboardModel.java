package mch.subschool.backend.model;

import lombok.Data;

import java.util.List;

/**
 * Модель отображения на дашборде
 */
@Data
public class DashboardModel {
    /**
     * Id для выбранной БД
     */
    private String id;

    /**
     * Список каналов
     */
    private List<DashboardChannel> channelList;
}
