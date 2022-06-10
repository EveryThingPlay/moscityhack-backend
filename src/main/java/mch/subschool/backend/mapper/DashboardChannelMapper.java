package mch.subschool.backend.mapper;

import mch.subschool.backend.dto.DashboardChannelDto;
import mch.subschool.backend.model.DashboardChannel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DashboardCampaignMapper.class})
public interface DashboardChannelMapper {
    @Mapping(target = "campaignDtoList", source = "campaignList")
    @Mapping(target = "channelName", source = "channelName")
    DashboardChannelDto toDto(DashboardChannel channelModel);

    @Mapping(target = "campaignList", source = "campaignDtoList")
    @Mapping(target = "channelName", source = "channelName")
    DashboardChannel fromDto(DashboardChannelDto channelDto);
}
