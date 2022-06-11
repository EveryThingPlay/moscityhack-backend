package mch.subschool.backend.service;

import mch.subschool.backend.model.DashboardModel;

import java.util.List;

// TODO: 11.06.2022 Удалить после завершения настройки сервиса по профилям
/**
 * Сервис дублирует изменения дашбордов в свою коллекцию без привязки к пользователю
  */
public interface DashboardService {
    String saveDashboardModel(DashboardModel dashboardModel);
    DashboardModel getDashboardModelById(String id);

    List<DashboardModel> getAllDashboardsModel();
}
