package mch.subschool.backend.mapper;

import mch.subschool.backend.dto.DashboardCampaignDto;
import mch.subschool.backend.model.DashboardCampaign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DashboardOfferMapper.class})
public interface DashboardCampaignMapper {
    @Mapping(target = "offerDtoList", source = "offerList")
    @Mapping(target = "campaignName", source = "campaignName")
    DashboardCampaignDto toDto(DashboardCampaign campaignModel);

    @Mapping(target = "offerList", source = "offerDtoList")
    @Mapping(target = "campaignName", source = "campaignName")
    DashboardCampaign fromDto(DashboardCampaignDto campaignDto);
}
