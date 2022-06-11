package mch.subschool.backend.service;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.DashboardChannel;
import mch.subschool.backend.model.DashboardModel;

import java.util.List;

/**
 * Сервис по работе с дашбордами для определенного пользователя.
 */
public interface ProfileDashboardService {
    boolean saveDashboardInProfile(Profile profile, DashboardModel dashboardModel);
    List<DashboardChannel> getChannelList(Profile profile);
    DashboardChannel getChannel(Profile profile, String channelName);
    boolean addChannel(Profile profile, DashboardChannel channel);
    boolean addChannelList(Profile profile, List<DashboardChannel> channelList);

}
