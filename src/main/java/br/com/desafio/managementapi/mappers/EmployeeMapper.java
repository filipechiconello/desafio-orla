package br.com.desafio.managementapi.mappers;

import br.com.desafio.managementapi.dtos.requests.EmployeeRequestDTO;
import br.com.desafio.managementapi.dtos.responses.EmployeeResponseDTO;
import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.entities.ProjectEntity;
import br.com.desafio.managementapi.services.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProjectService projectService;

    public EmployeeEntity toEntity(EmployeeRequestDTO request) {
        List<ProjectEntity> list = new ArrayList<>();
        EmployeeEntity employeeEntity = mapper.map(request, EmployeeEntity.class);

        request.getProjectIds().forEach(projectId -> {
            list.add(projectService.findById(projectId));
        });

        employeeEntity.setProjects(list);

        return employeeEntity;
    }

    public EmployeeResponseDTO toDto(EmployeeEntity entity) {
        return mapper.map(entity, EmployeeResponseDTO.class);
    }

    public List<EmployeeResponseDTO> toDtoList(Iterable<EmployeeEntity> list) {
        List<EmployeeEntity> result = new ArrayList<>();
        list.forEach(result::add);

        return result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}