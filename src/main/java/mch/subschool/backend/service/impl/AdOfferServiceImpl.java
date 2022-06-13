package mch.subschool.backend.service.impl;

import lombok.AllArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.adoffer.AdOffer;
import mch.subschool.backend.repository.AdOfferRepository;
import mch.subschool.backend.service.AdOfferService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AdOfferServiceImpl implements AdOfferService {
    private final AdOfferRepository adOfferRepository;

    @Override
    public List<AdOffer> getOfferListByProfile(Profile profile) {
        return adOfferRepository.getByMaintainerId(profile.getId());
    }

    @Override
    public List<AdOffer> getAllOffers() {
        return adOfferRepository.getAll();
    }

    @Override
    public AdOffer getOfferById(String offerId) {
        Optional<AdOffer> adOfferOptional = adOfferRepository.get(offerId);

        if (adOfferOptional.isPresent()) {
            return adOfferOptional.get();
        }

        throw new IllegalStateException(String.format("AdOffer with id %s not found", offerId));
    }

    @Override
    public String createOffer(AdOffer adOffer) {
        return adOfferRepository.saveAdOffer(adOffer);
    }

    @Override
    public void deleteOffer(String offerId) {
        adOfferRepository.deleteAdOffer(offerId);
    }

    @Override
    public void updateOffer(String offerId, AdOffer newOffer) {
        adOfferRepository.updateAdOffer(offerId, newOffer);
    }
}
