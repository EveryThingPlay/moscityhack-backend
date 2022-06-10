package mch.subschool.backend.mapper;

import mch.subschool.backend.dto.DashboardDto;
import mch.subschool.backend.model.DashboardModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DashboardChannelMapper.class})
public interface DashboardMapper {
    @Mapping(target = "channelDtoList", source = "channelList")
    DashboardDto toDto(DashboardModel dashboardModel);

    @Mapping(target = "channelList", source = "channelDtoList")
    DashboardModel fromDto(DashboardDto dashboardDto);
}
