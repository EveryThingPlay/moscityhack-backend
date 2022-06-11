package mch.subschool.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
public class DashboardDto {
    @JsonProperty("channelList")
    List<DashboardChannelDto> channelDtoList;
}
