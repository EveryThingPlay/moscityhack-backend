package mch.subschool.backend.service.impl;

import lombok.RequiredArgsConstructor;
import mch.subschool.backend.dto.DashboardDto;
import mch.subschool.backend.mapper.DashboardMapper;
import mch.subschool.backend.model.DashboardModel;
import mch.subschool.backend.service.MapperService;

@RequiredArgsConstructor
public class DashboardMapperService implements MapperService<DashboardDto, DashboardModel> {
    private final DashboardMapper mapper;

    @Override
    public DashboardDto toDto(DashboardModel model) {
        return mapper.toDto(model);
    }

    @Override
    public DashboardModel fromDto(DashboardDto dto) {
        return mapper.fromDto(dto);
    }
}
