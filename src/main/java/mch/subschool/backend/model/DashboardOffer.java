package mch.subschool.backend.model;

import lombok.Data;
import mch.subschool.backend.common.Statistic;

/**
 * Пост (объявление)
 */
@Data
public class DashboardOffer {
    /**
     * Статистика по посту
     */
    private Statistic statistic;

    /**
     * Имя объявления
     */
    private String offerName;
}
