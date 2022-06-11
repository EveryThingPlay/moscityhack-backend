package mch.subschool.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.DashboardChannel;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.service.ProfileDashboardService;
import mch.subschool.backend.service.ProfileService;

import java.util.List;

@RequiredArgsConstructor
public class ProfileDashboardServiceImpl implements ProfileDashboardService {
    private final ProfileService profileService;

    @Override
    public boolean saveDashboardInProfile(Profile profile, DashboardModel dashboardModel) {
        profile.setDashboardModel(dashboardModel);

        return profileService.updateProfile(profile.getId(), profile);
    }

    @Override
    public List<DashboardChannel> getChannelList(Profile profile) {
        return null;
    }

    @Override
    public DashboardChannel getChannel(Profile profile, String channelName) {
        return null;
    }

    @Override
    public boolean addChannel(Profile profile, DashboardChannel channel) {
        return false;
    }

    @Override
    public boolean addChannelList(Profile profile, List<DashboardChannel> channelList) {
        return false;
    }
}
