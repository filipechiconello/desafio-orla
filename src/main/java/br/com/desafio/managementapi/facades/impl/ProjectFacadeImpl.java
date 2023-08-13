package br.com.desafio.managementapi.facades.impl;

import br.com.desafio.managementapi.dtos.requests.ProjectRequestDTO;
import br.com.desafio.managementapi.dtos.responses.ProjectResponseDTO;
import br.com.desafio.managementapi.facades.ProjectFacade;
import br.com.desafio.managementapi.mappers.ProjectMapper;
import br.com.desafio.managementapi.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional()
public class ProjectFacadeImpl implements ProjectFacade {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMapper mapper;

    @Override
    public ProjectResponseDTO save(ProjectRequestDTO projectRequestDTO) {
        return mapper.toDto(projectService.save(mapper.toEntity(projectRequestDTO)));
    }

    @Override
    public List<ProjectResponseDTO> findAll() {
        return mapper.toDtoList(projectService.findAll());
    }
}