package mch.subschool.backend.common.profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileCommonInfo {
    private String login;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
}
