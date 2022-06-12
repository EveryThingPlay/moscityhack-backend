package mch.subschool.backend.controller;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.ProtectedWebResource;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.AdOfferDto;
import mch.subschool.backend.error.NoAccessForResourceException;
import mch.subschool.backend.mapper.AdOfferMapper;
import mch.subschool.backend.model.AdOffer;
import mch.subschool.backend.service.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/manager/")
@RequiredArgsConstructor
public class ManagerController implements ProtectedWebResource {
    private final static List<ProfileType> ADMITTED_PROFILE_TYPES = List.of(ProfileType.MANAGER);
    private final AdOfferMapper adOfferMapper;
    private final TokenService tokenService;
    private final ProfileService profileService;

    private final AdOfferService adOfferService;

    @GetMapping(value = "/ad-offers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdOfferDto> getAdOffers(@RequestHeader("Authorization") String token) {
        if (tokenService.isTokenAdmittedForResource(token, this)) {
            Profile profile = profileService.getProfileByToken(token);

            return adOfferService.getOfferListByProfile(profile).stream()
                    .map(adOfferMapper::toDto)
                    .collect(Collectors.toList());
        }

        throw new NoAccessForResourceException();
    }

    @PostMapping(value = "/ad-offers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String createAdOffer(@RequestHeader("Authorization") String token, @RequestBody AdOfferDto adOfferDto) {
        if (tokenService.isTokenAdmittedForResource(token, this)) {
            Profile profile = profileService.getProfileByToken(token);
            adOfferDto.setMaintainerId(profile.getId());

            return adOfferService.createOffer(adOfferMapper.fromDto(adOfferDto));
        }

        throw new NoAccessForResourceException();
    }

    @GetMapping(value = "/ad-offers/find",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AdOfferDto getAdOfferById(@RequestHeader("Authorization") String token, @RequestParam String id) {
        if (tokenService.isTokenAdmittedForResource(token, this)) {
            AdOffer adOffer = adOfferService.getOfferById(id);

            return adOfferMapper.toDto(adOffer);
        }

        throw new NoAccessForResourceException();
    }

    @Override
    public List<ProfileType> getAdmittedProfileTypeList() {
        return ADMITTED_PROFILE_TYPES;
    }
}
