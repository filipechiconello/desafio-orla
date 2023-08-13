package br.com.desafio.managementapi.services.impl;

import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.exceptions.EmployeeException;
import br.com.desafio.managementapi.exceptions.enums.EmployeeEnum;
import br.com.desafio.managementapi.repositories.EmployeeRepository;
import br.com.desafio.managementapi.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        log.info("creating new employee - {}", employeeEntity);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity findById(Long id) {
        log.info("listing employee by id - {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeException(EmployeeEnum.EMPLOYEE_NOT_FOUND));
    }

    @Override
    public List<EmployeeEntity> findAllByProjects_Id(Long projectId) {
        return employeeRepository.findAllByProjects_Id(projectId);
    }
}