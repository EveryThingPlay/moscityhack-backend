package mch.subschool.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.repository.DashboardRepository;
import mch.subschool.backend.service.DashboardService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final DashboardRepository repository;

    @Override
    public String saveDashboardModel(DashboardModel dashboardModel) {
        return repository.save(dashboardModel);
    }

    @Override
    public DashboardModel getDashboardModelById(String id) {
        Optional<DashboardModel> modelOptional = repository.get(id);

        if (modelOptional.isPresent()) {
            return modelOptional.get();
        }

        throw new IllegalStateException(String.format("DashboardModel with id %s not found!", id));
    }

    @Override
    public List<DashboardModel> getAllDashboardsModel() {
        return repository.getAll();
    }
}
