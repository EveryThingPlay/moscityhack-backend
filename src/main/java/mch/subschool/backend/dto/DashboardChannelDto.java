package mch.subschool.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DashboardChannelDto {
    @JsonProperty("campaignList")
    List<DashboardCampaignDto> campaignDtoList;
    String channelName;
}
