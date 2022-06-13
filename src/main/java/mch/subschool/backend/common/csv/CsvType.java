package mch.subschool.backend.common.csv;

/**
 * Тип файла CSV
 */
public enum CsvType {
    /**
     * Данные по CPC и CAC
     */
    CPC_AND_CAC,

    /**
     * Данные по клиенту
     */
    CLIENT_DATA,

    /**
     * Цена предложения
     */
    AD_OFFER_COST,

    /**
     * Профит от предложения
     */
    AD_OFFER_PROFIT
}
