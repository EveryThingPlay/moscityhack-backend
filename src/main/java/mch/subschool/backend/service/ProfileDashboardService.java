package mch.subschool.backend.service;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.DashboardModel;

/**
 * Сервис по работе с дашбордами для определенного пользователя.
 */
public interface ProfileDashboardService {
    boolean saveDashboardInProfile(Profile profile, DashboardModel dashboardModel);

}
