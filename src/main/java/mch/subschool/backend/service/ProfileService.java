package mch.subschool.backend.service;

import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.model.DashboardModel;

/**
 * Сервис по работе с профилями пользователей
 */
public interface ProfileService {
    /**
     * Получить профиль по Id
     * @param id Id пользователя
     * @return профиль пользователя
     */
    Profile getProfileById(String id);

    /**
     * Получить профиль по его персональному токену
     * @param token Id пользователя
     * @return профиль пользователя
     */
    Profile getProfileByToken(String token);

    /**
     * Создать профиль
     * @param newProfile профиль пользователя
     * @return персональный токен пользователя
     */
    String createProfile(Profile newProfile);

    /**
     * Обновить профиль
     * @param id Id пользователя
     * @param newProfile профиль с изменениями
     * @return результат обновления
     */
    boolean updateProfile(String id, Profile newProfile);

    /**
     * Удалить профиль по Id
     * @param id Id пользователя
     * @return результат удаления
     */
    boolean deleteProfile(String id);

    /**
     * Добавить дашборд в профиль
     * @param profile профиль пользователя
     * @param dashboardModel модель дашборда
     * @return профиль пользователя
     */
    boolean saveDashboardInProfile(Profile profile, DashboardModel dashboardModel);
}
