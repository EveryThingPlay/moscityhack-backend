package mch.subschool.backend.utils;

import mch.subschool.backend.common.profile.Profile;

import java.util.Base64;

public class TokenUtils {
    public static String createTokenForProfile(Profile profile) {
        String login = profile.getProfileCommonInfo().getLogin();
        String password = profile.getProfileCommonInfo().getPassword();
        String email = profile.getProfileCommonInfo().getEmail();
        String stringForEncoding = String.join("", login, password, email);
        byte[] bytesForEncoding = stringForEncoding.getBytes();

        return Base64.getEncoder().encodeToString(bytesForEncoding);
    }
}
