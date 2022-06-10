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
    private List<DashboardCampaign> campaignList;

    /**
     * Имя канала
     */
    private String channelName;
}
