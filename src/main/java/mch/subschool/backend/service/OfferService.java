package mch.subschool.backend.service;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> getOfferListByProfile(Profile profile);
    List<Offer> getAllOffers();
    Offer getOfferById(String offerId);
    void createOffer(Offer offer);
    void deleteOffer(String offerId);
    void updateOffer(String offerId, Offer newOffer);
}
