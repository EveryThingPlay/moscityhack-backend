package mch.subschool.backend.common.profile;

import lombok.Data;
import mch.subschool.backend.common.Requisite;

import java.util.List;

@Data
public class ProfileAdditiveInfo {
    private String firstName;
    private String lastName;
    private String middleName;
    private List<Requisite> requisiteList;
}
