package mch.subschool.backend.controller;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.ProtectedWebResource;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.DashboardDto;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.service.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dashboard")
@RequiredArgsConstructor
public class DashboardController implements ProtectedWebResource {
    private final static List<ProfileType> ADMITTED_PROFILE_TYPES = List.of(ProfileType.MANAGER, ProfileType.PUBLISHER);
    private final DashboardService dashboardService;
    private final MapperService<DashboardDto, DashboardModel> mapper;
    private final TokenService tokenService;
    private final ProfileService profileService;

    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveDashboardInfo(@RequestBody DashboardDto modelDto, @RequestHeader("Authorization") String token) {
        Profile profile = profileService.getProfileByToken(token);

        profileService.saveDashboardInProfile(profile, mapper.fromDto(modelDto));
    }

    @GetMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DashboardDto getDashboard(@RequestHeader("Authorization") String token) throws IllegalAccessException {
        if (tokenService.isTokenAdmittedForResource(token, this)) {
            return mapper.toDto(profileService.getProfileByToken(token).getDashboardModel());
        }

        throw new IllegalAccessException("Access fail!");
    }

    @Override
    public List<ProfileType> getAdmittedProfileTypeList() {
        return ADMITTED_PROFILE_TYPES;
    }
}
