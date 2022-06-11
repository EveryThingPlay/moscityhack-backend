package mch.subschool.backend.controller;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.common.profile.Profile;
import mch.subschool.backend.dto.LogInDto;
import mch.subschool.backend.dto.SignUpDto;
import mch.subschool.backend.mapper.ProfileMapper;
import mch.subschool.backend.service.LogInService;
import mch.subschool.backend.service.ProfileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/profile/")
@RequiredArgsConstructor
public class ProfileController {

}
