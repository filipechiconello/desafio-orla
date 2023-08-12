package br.com.desafio.managementapi.mappers;

import br.com.desafio.managementapi.dtos.requests.ProjectRequestDTO;
import br.com.desafio.managementapi.dtos.responses.ProjectResponseDTO;
import br.com.desafio.managementapi.entities.ProjectEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    @Autowired
    private ModelMapper mapper;

    public ProjectEntity toEntity(ProjectRequestDTO request) {
        return mapper.map(request, ProjectEntity.class);
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