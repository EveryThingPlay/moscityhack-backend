package mch.subschool.backend.dto;

import lombok.Data;
import mch.subschool.backend.common.ProductCategoryName;

@Data
public class AdOfferDto {
    String id;
    String maintainerId;
    String name;
    String description;
    String base64png;
    ProductCategoryName productCategoryName;
    String cardTypeName;
    Boolean isConversionDelegateNeeded;
    Boolean isBusinessmanDelegateNeeded;
    Boolean isNonResidentDelegateNeeded;
    Long cpa;//сколько заплатить в итоге контрагенту?
    Float payPercent;
}
