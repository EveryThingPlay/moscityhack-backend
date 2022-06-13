package mch.subschool.backend.repository;

import mch.subschool.backend.model.adoffer.AdOffer;

import java.util.List;
import java.util.Optional;

public interface AdOfferRepository {
    Optional<AdOffer> get(String id);
    List<AdOffer> getByMaintainerId(String maintainerId);
    List<AdOffer> getAll();
    String saveAdOffer(AdOffer adOffer);
    void updateAdOffer(String id, AdOffer newAdOffer);
    boolean deleteAdOffer(String id);
}
