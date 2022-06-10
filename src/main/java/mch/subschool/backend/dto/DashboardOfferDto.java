package mch.subschool.backend.dto;

import lombok.Data;
import lombok.Value;
import mch.subschool.backend.common.Statistic;

@Data
public class DashboardOfferDto {
    Statistic statistic;
    String offerName;
}
