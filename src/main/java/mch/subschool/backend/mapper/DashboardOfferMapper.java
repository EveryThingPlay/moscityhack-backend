package mch.subschool.backend.mapper;

import mch.subschool.backend.dto.DashboardOfferDto;
import mch.subschool.backend.model.DashboardOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DashboardOfferMapper {
    @Mapping(target = "statistic", source = "statistic")
    @Mapping(target = "offerName", source = "offerName")
    DashboardOfferDto toDto(DashboardOffer offerModel);

    @Mapping(target = "statistic", source = "statistic")
    @Mapping(target = "offerName", source = "offerName")
    DashboardOffer fromDto(DashboardOfferDto offerDto);
}
