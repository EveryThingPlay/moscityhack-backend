package mch.subschool.backend.model.profile.publisher;

import mch.subschool.backend.common.Requisite;
import mch.subschool.backend.common.profile.ProfileCommonInfo;

import java.util.List;

public class PublisherProfileInfo extends ProfileCommonInfo {
    private String firstName;
    private String lastName;
    private String middleName;
    private List<Requisite> requisiteList;
}
