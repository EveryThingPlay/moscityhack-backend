package mch.subschool.backend.common.profile;

import lombok.Data;
import mch.subschool.backend.common.Requisite;

import java.util.List;

/**
 * Дополнительная информация пользователя
 */
@Data
public class ProfileAdditiveInfo {
    /**
     * Реквизиты пользователя
     */
    private List<Requisite> requisiteList;
}
