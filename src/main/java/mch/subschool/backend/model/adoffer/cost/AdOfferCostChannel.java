package mch.subschool.backend.model.adoffer.cost;

import lombok.Data;

import java.util.List;

@Data
public class AdOfferCostChannel {
    private String channelName;
    private List<AdOfferCostCampaign> campaignList;
}
