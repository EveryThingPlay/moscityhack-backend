package mch.subschool.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class DashboardDto {
    List<DashboardChannelDto> channelDtoList;
}
