package mch.subschool.backend.dto;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
public class DashboardChannelDto {
    List<DashboardCampaignDto> campaignDtoList;
    String channelName;
}
