package mch.subschool.backend.model.profile.publisher;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;

public class PublisherProfile implements Profile {

    @Override
    public ProfileType getProfileType() {
        return ProfileType.PUBLISHER;
    }
}
