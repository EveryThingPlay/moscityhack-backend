package mch.subschool.backend.model;

import lombok.Data;
import mch.subschool.backend.common.ProductCategoryName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
public class AdOffer {
    @Id
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
