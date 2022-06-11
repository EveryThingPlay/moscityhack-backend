package mch.subschool.backend.dto;

import lombok.Data;
import mch.subschool.backend.common.ProductCategoryName;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
public class AdOfferDto {

    @MongoId
    String id;
    String name;
    String Description;
    byte[] png;

    ProductCategoryName productCategoryName;
    String cardTypeName;

    String reference;

    Boolean isConversionDelegateNeeded;
    Boolean isBusinessmanDelegateNeeded;
    Boolean isNonResidentDelegateNeeded;

    Long cpa;//сколько заплатить в итоге контрагенту?

    Float payPercent;
}
