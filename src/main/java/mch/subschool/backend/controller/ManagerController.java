package mch.subschool.backend.controller;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.ProtectedWebResource;
import mch.subschool.backend.common.csv.CsvType;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.dto.AdOfferDto;
import mch.subschool.backend.error.NoAccessForResourceException;
import mch.subschool.backend.mapper.AdOfferMapper;
import mch.subschool.backend.model.AdOffer;
import mch.subschool.backend.model.csv.CpcAndCac;
import mch.subschool.backend.service.*;
import mch.subschool.backend.service.csv.CsvParserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/manager/")
@RequiredArgsConstructor
public class ManagerController implements ProtectedWebResource {
    private final static List<ProfileType> ADMITTED_PROFILE_TYPES = List.of(ProfileType.MANAGER);
    private final List<CsvParserService<?>> csvParserServiceList;
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

    @GetMapping(value = "/export/cpc-and-cac",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CpcAndCac getAdOfferById(@RequestHeader("Authorization") String token,
                                    @RequestPart("file") MultipartFile file) throws IOException {
        if (tokenService.isTokenAdmittedForResource(token, this)) {
            return (CpcAndCac) getRequiredCsvParserService(CsvType.CPC_AND_CAC).parseCsvByFile(file).get(0);
        }

        throw new NoAccessForResourceException();
    }

    @Override
    public List<ProfileType> getAdmittedProfileTypeList() {
        return ADMITTED_PROFILE_TYPES;
    }

    private CsvParserService<?> getRequiredCsvParserService(CsvType csvType) {
        Optional<CsvParserService<?>> serviceOptional =
                csvParserServiceList.stream().filter(service -> service.getCsvType() == csvType).findFirst();

        if (serviceOptional.isPresent()) {
            return serviceOptional.get();
        }

        throw new IllegalStateException(String.format("CSV type %s not supported!", csvType.name()));
    }
}
