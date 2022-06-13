package mch.subschool.backend.service.csv.impl;

import mch.subschool.backend.model.AdOfferEfficiency;
import mch.subschool.backend.model.csv.AdOfferCostCsvData;
import mch.subschool.backend.model.csv.AdOfferProfitCsvData;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdOfferEfficiencyCsvToDBAdapter {

    public void createOrUpdateAdOfferEfficiencyWithProfit(List<AdOfferProfitCsvData> profitDataFromCsv)
    {
        // TODO: 13.06.2022
//        List<AdOfferEfficiency> adOfferEfficiency =new AdOfferEfficiency()
//        AdOfferEfficiency adOfferEfficiency = ;
//
//        adOfferEfficiency.setOfferName(profitDataFromCsv.getAdOffer());
//
//        adOfferEfficiency.setSales(profitDataFromCsv.getSales());
//        adOfferEfficiency.setContractSum(profitDataFromCsv.getContractSum());
//        adOfferEfficiency.setAverageActualBalanceSum(profitDataFromCsv.getAverageActualBalanceSum());

        throw new NotImplementedException();

    }

    public void createOrUpdateAdOfferEfficiencyWithCost(List<AdOfferCostCsvData> costDataFromCsv)
    {
        // TODO: 13.06.2022
//        AdOfferEfficiency adOfferEfficiency = new AdOfferEfficiency();
//
//        adOfferEfficiency.setOfferName(costDataFromCsv.getAdOffer());
//
//        adOfferEfficiency.setInteractionCost(costDataFromCsv.getInteractionCost());
//        adOfferEfficiency.setCoverage(costDataFromCsv.getCoverage());
//        adOfferEfficiency.setInteraction(costDataFromCsv.getInteraction());

        throw new NotImplementedException();
    }




}
