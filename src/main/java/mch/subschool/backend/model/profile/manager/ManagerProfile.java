package mch.subschool.backend.model.profile.manager;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.common.profile.RoleProfile;

@Data
@EqualsAndHashCode(callSuper = true)
public class ManagerProfile extends Profile implements RoleProfile {
}
