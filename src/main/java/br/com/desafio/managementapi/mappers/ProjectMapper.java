package br.com.desafio.managementapi.mappers;

import br.com.desafio.managementapi.dtos.requests.ProjectRequestDTO;
import br.com.desafio.managementapi.dtos.responses.ProjectResponseDTO;
import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.entities.ProjectEntity;
import br.com.desafio.managementapi.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProjectMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeService employeeService;

    public ProjectEntity toEntity(ProjectRequestDTO request) {
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        ProjectEntity project = mapper.map(request, ProjectEntity.class);
        request.getEmployeeIds().forEach(employeeId -> {
            employeeEntityList.add(employeeService.findById(employeeId));
        });

        project.setEmployees(employeeEntityList);

        return project;
    }

    public ProjectResponseDTO toDto(ProjectEntity entity) {
        return mapper.map(entity, ProjectResponseDTO.class);
    }

    public List<ProjectResponseDTO> toDtoList(Iterable<ProjectEntity> list) {
        List<ProjectEntity> result = new ArrayList<>();
        list.forEach(result::add);

        return result.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}