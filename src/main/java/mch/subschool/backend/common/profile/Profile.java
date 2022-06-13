package mch.subschool.backend.common.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mch.subschool.backend.model.DashboardModel;
import org.springframework.data.annotation.Id;

/**
 * Профиль пользователя
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    private String id;

    /**
     * Модель дашборда пользователя
     */
    private DashboardModel dashboardModel;

    /**
     * Тип профиля
     */
    private ProfileType profileType;

    /**
     * Персональный токен пользователя
     */
    private String token;

    /**
     * Основная информация пользователя
     */
    private ProfileCommonInfo profileCommonInfo;

    /**
     * Дополнительная информация пользователя
     */
    private ProfileAdditiveInfo profileAdditiveInfo;
}
