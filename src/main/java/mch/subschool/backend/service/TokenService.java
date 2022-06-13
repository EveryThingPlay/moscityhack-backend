package mch.subschool.backend.service;

import mch.subschool.backend.common.ProtectedWebResource;

/**
 * Сервис по работе с токенами пользователей
 */
public interface TokenService {
    /**
     * Доступен ли пользователю запрашиваемый ресурс
     * @param token токен пользователя
     * @param resource запрашиваемый ресурс
     * @return true - доступен, false - недоступен
     */
    boolean isTokenAdmittedForResource(String token, ProtectedWebResource resource);
}
