package br.com.desafio.managementapi.facades;

import br.com.desafio.managementapi.dtos.requests.ProjectRequestDTO;
import br.com.desafio.managementapi.dtos.responses.ProjectResponseDTO;

import java.util.List;

public interface ProjectFacade {

    ProjectResponseDTO save(ProjectRequestDTO projectRequestDTO);

    List<ProjectResponseDTO> findAll();
}
