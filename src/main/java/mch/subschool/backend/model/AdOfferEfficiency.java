package mch.subschool.backend.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvNumber;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AdOfferEfficiency {

    @Id
    String id;

    String offerName;

    Integer coverage;
    Integer interaction;
    Float interactionCost;

    Integer sales;
    Long contractSum;
    Long averageActualBalanceSum;
}
