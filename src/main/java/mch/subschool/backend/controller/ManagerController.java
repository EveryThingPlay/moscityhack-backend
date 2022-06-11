package mch.subschool.backend.controller;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.ProtectedWebResource;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.AdOfferDto;
import mch.subschool.backend.dto.DashboardChannelDto;
import mch.subschool.backend.dto.DashboardDto;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.service.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/manager/")
@RequiredArgsConstructor
public class ManagerController implements ProtectedWebResource {
    private final static List<ProfileType> ADMITTED_PROFILE_TYPES = List.of(ProfileType.MANAGER);
    private final MapperService<DashboardDto, DashboardModel> mapper;
    private final TokenService tokenService;
    private final ProfileService profileService;

    private final OfferService adOfferService;

    @GetMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DashboardDto getDashboard(@RequestHeader("Authorization") String token) throws IllegalAccessException {
        return tokenService.getResultIfTokenValid(
                token,
                this,
                mapper::toDto,
                profileService.getProfileByToken(token).getDashboardModel());
    }

    @GetMapping(value = "/getAdOffers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AdOfferDto getAdOffers(@RequestHeader("Authorization") String token) throws IllegalAccessException {
        return tokenService.getResultIfTokenValid(
                token,
                this,
                adOfferService.getAllOffers(),
                null);
    }

    public List<DashboardChannelDto> getChannelList(@RequestHeader("Authorization") String token) throws IllegalAccessException {
        throw new IllegalAccessException("Access fail!");
    }

    @Override
    public List<ProfileType> getAdmittedProfileTypeList() {
        return ADMITTED_PROFILE_TYPES;
    }
}
