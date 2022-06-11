package mch.subschool.backend.common.profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileInfo {
    private String login;
    private String email;
    private String passHash;
}
