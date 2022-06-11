package mch.subschool.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.service.ProfileDashboardService;
import mch.subschool.backend.service.ProfileService;

@RequiredArgsConstructor
public class ProfileDashboardServiceImpl implements ProfileDashboardService {
    private final ProfileService profileService;

    @Override
    public boolean saveDashboardInProfile(Profile profile, DashboardModel dashboardModel) {
        profile.setDashboardModel(dashboardModel);

        return profileService.updateProfile(profile.getId(), profile);
    }
}
