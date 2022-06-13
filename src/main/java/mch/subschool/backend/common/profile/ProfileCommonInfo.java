package mch.subschool.backend.common.profile;

import lombok.Getter;
import lombok.Setter;

/**
 * Основная информация пользователя
 */
@Getter
@Setter
public class ProfileCommonInfo {
    /**
     * Логин пользователя
     */
    private String login;

    /**
     * Электронная почта пользователя
     */
    private String email;

    /**
     * Пароль пользователя
     */
    private String password;

    /**
     * Имя пользователя
     */
    private String firstName;

    /**
     * Фамилия пользователя
     */
    private String lastName;

    /**
     * Отчество пользователя
     */
    private String middleName;
}
