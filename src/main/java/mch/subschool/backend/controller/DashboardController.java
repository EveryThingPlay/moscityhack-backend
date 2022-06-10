package mch.subschool.backend.controller;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.dto.DashboardDto;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.service.DashboardService;
import mch.subschool.backend.service.MapperService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/dashboard/")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;
    private final MapperService<DashboardDto, DashboardModel> mapper;

    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveDashboardInfo(@RequestBody DashboardDto modelDto) {
        return dashboardService.saveDashboardModel(mapper.fromDto(modelDto));
    }

    @GetMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DashboardDto> getAllDashboardInfo() {
        return dashboardService.getAllDashboardsModel()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
