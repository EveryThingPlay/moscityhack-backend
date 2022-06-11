package mch.subschool.backend.repository.mongo;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.repository.DashboardRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MongoDashboardRepository implements DashboardRepository {
    private final MongoTemplate mongo;
    private static final String COLLECTION_NAME = "dashboards";

    @Override
    public Optional<DashboardModel> get(String id) {
        DashboardModel model = mongo.findById(id, DashboardModel.class, COLLECTION_NAME);

        return model == null ? Optional.empty() : Optional.of(model);
    }

    @Override
    public List<DashboardModel> getAll() {
        return mongo.findAll(DashboardModel.class, COLLECTION_NAME);
    }

    @Override
    public String save(DashboardModel dashboardModel) {
        return mongo.save(dashboardModel, COLLECTION_NAME).getId();
    }

    @Override
    public boolean delete(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);

        return mongo.remove(query, COLLECTION_NAME).wasAcknowledged();
    }

    @Override
    public boolean update(String id, DashboardModel newDashboardModel) {
        if (delete(id)) {
            newDashboardModel.setId(id);

            return !save(newDashboardModel).isEmpty();
        }

        throw new IllegalStateException(String.format("DashboardModel with id %s not found. Updating failed!", id));
    }
}
