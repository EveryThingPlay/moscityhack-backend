package mch.subschool.backend.common;

import mch.subschool.backend.common.profile.ProfileType;

import java.util.List;

/**
 * Ресурс, имеющий ограничения доступа
 */
public interface ProtectedWebResource {
    /**
     * Получить типы профилей, допущенные к ресурсу
     *
     * @return типы профилей, допущенные к ресурсу
     */
    List<ProfileType> getAdmittedProfileTypeList();
}

