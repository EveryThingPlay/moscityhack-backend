package mch.subschool.backend.model;

import lombok.Data;
import mch.subschool.backend.common.ProductCategoryName;
import org.springframework.data.annotation.Id;

@Data
public class AdOffer {
    @Id
    private String id;
    private String maintainerId;
    private String name;
    private String description;
    private String base64png;
    private ProductCategoryName productCategoryName;
    private String cardTypeName;
    private Boolean isConversionDelegateNeeded;
    private Boolean isBusinessmanDelegateNeeded;
    private Boolean isNonResidentDelegateNeeded;
    private Long cpa;//сколько заплатить в итоге контрагенту?
    private Float payPercent;
}
