package mch.subschool.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mch.subschool.backend.common.profile.ProfileType;
import mch.subschool.backend.model.profile.publisher.PublisherProfileInfo;

@Data
@EqualsAndHashCode(callSuper = true)
public class PublisherProfileDto extends ProfileDto{
}
