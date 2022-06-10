package mch.subschool.backend.model;

import lombok.Data;

import java.util.List;

/**
 * Кампания
 */
@Data
public class DashboardCampaign {
    /**
     * Список постов (объявлений) в кампании
     */
    private List<DashboardOffer> offerList;

    /**
     * Имя кампании
     */
    private String campaignName;
}
