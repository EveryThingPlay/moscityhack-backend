package mch.subschool.backend.mapper;

import mch.subschool.backend.dto.AdOfferDto;
import mch.subschool.backend.model.AdOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdOfferMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "maintainerId", source = "maintainerId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "base64png", source = "base64png")
    @Mapping(target = "productCategoryName", source = "productCategoryName")
    @Mapping(target = "cardTypeName", source = "cardTypeName")
    @Mapping(target = "isConversionDelegateNeeded", source = "isConversionDelegateNeeded")
    @Mapping(target = "isBusinessmanDelegateNeeded", source = "isBusinessmanDelegateNeeded")
    @Mapping(target = "isNonResidentDelegateNeeded", source = "isNonResidentDelegateNeeded")
    @Mapping(target = "cpa", source = "cpa")
    @Mapping(target = "payPercent", source = "payPercent")
    AdOfferDto toDto(AdOffer adOffer);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "maintainerId", source = "maintainerId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "base64png", source = "base64png")
    @Mapping(target = "productCategoryName", source = "productCategoryName")
    @Mapping(target = "cardTypeName", source = "cardTypeName")
    @Mapping(target = "isConversionDelegateNeeded", source = "isConversionDelegateNeeded")
    @Mapping(target = "isBusinessmanDelegateNeeded", source = "isBusinessmanDelegateNeeded")
    @Mapping(target = "isNonResidentDelegateNeeded", source = "isNonResidentDelegateNeeded")
    @Mapping(target = "cpa", source = "cpa")
    @Mapping(target = "payPercent", source = "payPercent")
    AdOffer fromDto(AdOfferDto adOfferDto);
}
