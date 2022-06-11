package mch.subschool.backend.model.profile.manager;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;

public class ManagerProfile implements Profile {
    private ManagerProfileInfo profileInfo;

    @Override
    public ProfileType getProfileType() {
        return ProfileType.MANAGER;
    }
}
