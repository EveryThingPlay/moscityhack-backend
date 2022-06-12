package mch.subschool.backend.common.profile;

import lombok.Data;
import mch.subschool.backend.common.Requisite;

import java.util.List;

@Data
public class ProfileAdditiveInfo {
    private List<Requisite> requisiteList;
}
