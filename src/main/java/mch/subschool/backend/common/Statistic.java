package mch.subschool.backend.common;

import lombok.Data;

/**
 * Статистика
 */
@Data
public class Statistic {
    /**
     * Охват - Количество просмотров
     */
    private Long audienceReach;

    /**
     * Взаимодействия - Количество переходов
     */
    private Long interactionCount;

    /**
     * Стоимость взаимодействия - CPC
     */
    private Long interactionPrice;

    /**
     * Продажи - (вводится отдельно)
     */
    private Long sales;

    /**
     * CAC - CPC*Клик/Продажи
     */
    private Double cac;

    /**
     * ARPU - вводится отдельно
     */
    private Double apru;

    /**
     * LTV - вводится отдельно
     */
    private Double ltv;

    /**
     * ROI - (LTV - CAC)/CAC
     */
    private Double roi;
}
