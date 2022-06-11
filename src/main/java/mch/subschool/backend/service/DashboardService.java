package mch.subschool.backend.service;

import mch.subschool.backend.model.DashboardModel;

import java.util.List;

public interface DashboardService {
    String saveDashboardModel(DashboardModel dashboardModel);
    DashboardModel getDashboardModelById(String id);

    List<DashboardModel> getAllDashboardsModel();
}
