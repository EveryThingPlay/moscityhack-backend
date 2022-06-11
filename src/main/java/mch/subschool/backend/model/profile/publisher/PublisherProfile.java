package mch.subschool.backend.model.profile.publisher;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.RoleProfile;

@Data
@EqualsAndHashCode(callSuper = true)
public class PublisherProfile extends Profile implements RoleProfile {
}
