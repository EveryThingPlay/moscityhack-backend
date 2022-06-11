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
     * Сумма контрактов - Вводится
     */
    private Long contractsAmount;

    /**
     * Средний контракт = “Сумма контрактов”/продажи
     */
    private Boolean contractsAverage;

    /**
     * Сумма средних актуальных балансов - Вводится
     */
    private Boolean averageCurrentBalancesSum;

    /**
     * Средний баланс = “Сумма средних актуальных балансов”/продажи
     */
    private Boolean averageBalance;

    /**
     * ROI - (LTV - CAC)/CAC
     */
    private Double roi;
}
