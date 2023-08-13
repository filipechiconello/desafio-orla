package br.com.desafio.managementapi.facades.impl;

import br.com.desafio.managementapi.dtos.requests.EmployeeRequestDTO;
import br.com.desafio.managementapi.dtos.responses.EmployeeResponseDTO;
import br.com.desafio.managementapi.facades.EmployeeFacade;
import br.com.desafio.managementapi.mappers.EmployeeMapper;
import br.com.desafio.managementapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional()
public class EmployeeFacadeImpl implements EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public List<EmployeeResponseDTO> findAllByProjects_Id(Long projectId) {
        return mapper.toDtoList(employeeService.findAllByProjectsId(projectId));
    }

    @Override
    public EmployeeResponseDTO save(EmployeeRequestDTO employeeRequestDTO) {
        return mapper.toDto(employeeService.save(mapper.toEntity(employeeRequestDTO)));
    }
}