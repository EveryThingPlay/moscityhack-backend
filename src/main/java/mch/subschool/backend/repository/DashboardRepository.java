package mch.subschool.backend.repository;

import mch.subschool.backend.model.DashboardModel;

import java.util.List;
import java.util.Optional;

public interface DashboardRepository {
    Optional<DashboardModel> get(String id);
    List<DashboardModel> getAll();
    String save(DashboardModel dashboardModel);
    boolean delete(String id);
    boolean update(String id, DashboardModel newDashboardModel);
}
