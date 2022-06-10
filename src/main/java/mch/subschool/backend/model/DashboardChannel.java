package mch.subschool.backend.model;

import lombok.Data;

import java.util.List;

/**
 * Канал
 */
@Data
public class DashboardChannel {
    /**
     * Список кампаний в канале
     */
    private List<DashboardCampaign> companyList;

    /**
     * Имя канала
     */
    private String channelName;
}
