package br.com.desafio.managementapi.facades;

import br.com.desafio.managementapi.dtos.requests.EmployeeRequestDTO;
import br.com.desafio.managementapi.dtos.responses.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeFacade {

    List<EmployeeResponseDTO> findAllByProjects_Id(Long projectId);

    EmployeeResponseDTO save(EmployeeRequestDTO employeeRequestDTO);
}
