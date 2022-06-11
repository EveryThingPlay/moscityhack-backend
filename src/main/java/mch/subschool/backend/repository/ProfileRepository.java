package mch.subschool.backend.repository;

import mch.subschool.backend.common.profile.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {
    Optional<Profile> get(String id);
    Optional<Profile> getByToken(String token);
    Optional<Profile> getByLoginAndPassword(String login, String password);
    List<Profile> getAll();
    String save(Profile profile);
    boolean delete(String id);
    boolean update(String id, Profile newProfile);
}
