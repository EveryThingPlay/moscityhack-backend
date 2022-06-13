package mch.subschool.backend.repository.mongo;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.model.adoffer.AdOffer;
import mch.subschool.backend.repository.AdOfferRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MongoAdOfferRepository implements AdOfferRepository {
    private final MongoTemplate mongo;
    private static final String COLLECTION_NAME = "ad_offers";

    @Override
    public Optional<AdOffer> get(String id) {
        AdOffer adOffer = mongo.findById(id, AdOffer.class, COLLECTION_NAME);

        return adOffer == null ? Optional.empty() : Optional.of(adOffer);
    }

    @Override
    public List<AdOffer> getByMaintainerId(String maintainerId) {
        Criteria criteria = Criteria.where("maintainerId").is(maintainerId);
        Query query = new Query(criteria);

        return mongo.find(query, AdOffer.class, COLLECTION_NAME);
    }

    @Override
    public List<AdOffer> getAll() {
        return mongo.findAll(AdOffer.class, COLLECTION_NAME);
    }

    @Override
    public String saveAdOffer(AdOffer adOffer) {
        return mongo.save(adOffer, COLLECTION_NAME).getId();
    }

    @Override
    public void updateAdOffer(String id, AdOffer newAdOffer) {
        if (deleteAdOffer(id)) {
            newAdOffer.setId(id);

            saveAdOffer(newAdOffer);
            return;
        }

        throw new IllegalStateException(String.format("AdOffer with id %s not found. Updating failed!", id));
    }

    @Override
    public boolean deleteAdOffer(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);

        return mongo.remove(query, COLLECTION_NAME).wasAcknowledged();
    }
}
