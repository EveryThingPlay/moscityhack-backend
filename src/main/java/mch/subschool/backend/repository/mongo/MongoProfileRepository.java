package mch.subschool.backend.repository.mongo;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.model.profile.manager.ManagerProfile;
import mch.subschool.backend.model.profile.publisher.PublisherProfile;
import mch.subschool.backend.repository.ProfileRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MongoProfileRepository implements ProfileRepository {
    private final MongoTemplate mongo;
    private static final String COLLECTION_NAME = "profiles";

    @Override
    public Optional<Profile> get(String id) {
        Profile profile = mongo.findById(id, Profile.class, COLLECTION_NAME);

        return profile == null ? Optional.empty() : Optional.of(profile);
    }

    @Override
    public Optional<Profile> getByToken(String token) {
        Criteria criteria = Criteria.where("token").is(token);
        Query query = new Query(criteria);
        Profile profile = mongo.findOne(query, Profile.class, COLLECTION_NAME);

        return profile == null ? Optional.empty() : Optional.of(profile);
    }

    @Override
    public Optional<Profile> getByLoginAndPassword(String login, String password) {
        Criteria criteria = Criteria
                .where("profileCommonInfo.login").is(login)
                .and("profileCommonInfo.password").is(password);
        Query query = new Query(criteria);
        Profile profile = mongo.findOne(query, Profile.class);

        return profile == null ? Optional.empty() : Optional.of(profile);
    }

    @Override
    public List<Profile> getAll() {
        return mongo.findAll(Profile.class, COLLECTION_NAME);
    }

    @Override
    public String save(Profile profile) {
        return mongo.save(profile, COLLECTION_NAME).getToken();
    }

    @Override
    public boolean delete(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);

        return mongo.remove(query, COLLECTION_NAME).wasAcknowledged();
    }

    @Override
    public boolean update(String id, Profile newProfile) {
        if (delete(id)) {
            newProfile.setId(id);

            return !save(newProfile).isEmpty();
        }

        throw new IllegalStateException(String.format("Profile with id %s not found. Updating failed!", id));
    }
}
