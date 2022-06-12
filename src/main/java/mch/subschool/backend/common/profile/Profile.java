package mch.subschool.backend.common.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mch.subschool.backend.model.DashboardModel;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    private String id;
    private DashboardModel dashboardModel;
    private ProfileType profileType;
    private String token;
    private ProfileCommonInfo profileCommonInfo;
    private ProfileAdditiveInfo profileAdditiveInfo;
}
