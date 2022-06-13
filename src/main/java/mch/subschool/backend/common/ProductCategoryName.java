package mch.subschool.backend.common;

/**
 * Категория предлагаемого продукта
 */
public enum ProductCategoryName {
    DEBET_CARD("Договор на текущий счет для дебетовой карты"),
    CREDIT_CARD( "Кредитная карта");

    public String getRusName() {
        return rusName;
    }

    ProductCategoryName(String rusName) {
        this.rusName = rusName;
    }

    private final String rusName;

}
