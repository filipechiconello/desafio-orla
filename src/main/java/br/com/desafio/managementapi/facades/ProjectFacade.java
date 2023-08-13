package br.com.desafio.managementapi.facades;

import br.com.desafio.managementapi.dtos.requests.ProjectRequestDTO;
import br.com.desafio.managementapi.dtos.responses.EmployeeResponseDTO;
import br.com.desafio.managementapi.dtos.responses.ProjectResponseDTO;
import br.com.desafio.managementapi.entities.EmployeeEntity;

import java.util.List;

public interface ProjectFacade {

    ProjectResponseDTO save(ProjectRequestDTO projectRequestDTO);

    List<ProjectResponseDTO> findAll();

    List<EmployeeResponseDTO> findByEmployees(Long projectId);
}
