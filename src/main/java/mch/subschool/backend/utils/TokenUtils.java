package mch.subschool.backend.utils;

import mch.subschool.backend.common.profile.Profile;

import java.util.Base64;

/**
 * Инструмент по работе с токенами
 */
public class TokenUtils {
    /**
     * Сгенерировать токен для пользователя
     * @param profile профиль пользователя
     * @return токен пользователя
     */
    public static String createTokenForProfile(Profile profile) {
        String login = profile.getProfileCommonInfo().getLogin();
        String password = profile.getProfileCommonInfo().getPassword();
        String email = profile.getProfileCommonInfo().getEmail();
        String stringForEncoding = String.join("", login, password, email);
        byte[] bytesForEncoding = stringForEncoding.getBytes();

        return Base64.getEncoder().encodeToString(bytesForEncoding);
    }
}
