package mch.subschool.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DashboardCampaignDto {
    @JsonProperty("offerList")
    List<DashboardOfferDto> offerDtoList;
    String campaignName;
}
