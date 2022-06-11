package mch.subschool.backend.service;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.DashboardModel;

public interface ProfileService {
    Profile getProfileById(String id);
    Profile getProfileByToken(String token);
    String createProfile(Profile newProfile);
    boolean updateProfile(String id, Profile newProfile);
    boolean deleteProfile(String id);
    boolean saveDashboardInProfile(Profile profile, DashboardModel dashboardModel);
}
