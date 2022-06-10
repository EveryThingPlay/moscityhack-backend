package mch.subschool.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class DashboardCampaignDto {
    List<DashboardOfferDto> offerDtoList;
    String campaignName;
}
