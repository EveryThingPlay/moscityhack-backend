package mch.subschool.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.repository.ProfileRepository;
import mch.subschool.backend.service.ProfileService;
import mch.subschool.backend.utils.TokenUtils;

import java.util.Optional;

@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository repository;

    @Override
    public Profile getProfileById(String id) {
        Optional<Profile> profileOptional = repository.get(id);

        if (profileOptional.isPresent()) {
            return profileOptional.get();
        }

        throw new IllegalStateException(String.format("Profile with id %s not found.", id));
    }

    @Override
    public Profile getProfileByToken(String token) {
        Optional<Profile> profileOptional = repository.getByToken(token);

        if (profileOptional.isPresent()) {
            return profileOptional.get();
        }

        throw new IllegalStateException(String.format("Profile with token %s not found.", token));
    }

    @Override
    public String createProfile(Profile newProfile) {
        String token = TokenUtils.createTokenForProfile(newProfile);
        newProfile.setToken(token);

        return repository.save(newProfile);
    }

    @Override
    public boolean updateProfile(String id, Profile newProfile) {
        return repository.update(id, newProfile);
    }

    @Override
    public boolean deleteProfile(String id) {
        return repository.delete(id);
    }

    @Override
    public boolean saveDashboardInProfile(Profile profile, DashboardModel dashboardModel) {
        profile.setDashboardModel(dashboardModel);

        return updateProfile(profile.getId(), profile);
    }
}
