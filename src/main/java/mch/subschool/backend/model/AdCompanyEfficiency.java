package mch.subschool.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class AdCompanyEfficiency {

    @Id
    int id;

    String companyName;

    List<AdOfferEfficiency> adOfferEfficiencies;
}

