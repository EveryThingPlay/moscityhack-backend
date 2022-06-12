package mch.subschool.backend.service;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.AdOffer;

import java.util.List;

public interface AdOfferService {
    List<AdOffer> getOfferListByProfile(Profile profile);
    List<AdOffer> getAllOffers();
    AdOffer getOfferById(String offerId);
    String createOffer(AdOffer offer);
    void deleteOffer(String offerId);
    void updateOffer(String offerId, AdOffer newOffer);
}
