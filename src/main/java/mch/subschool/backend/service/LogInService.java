package mch.subschool.backend.service;

import mch.subschool.backend.dto.LogInDto;

/**
 * Сервис для входа в систему
 */
public interface LogInService {
    String logIn(LogInDto logInDto);
}
