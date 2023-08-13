package br.com.desafio.managementapi.services;

import br.com.desafio.managementapi.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity save(EmployeeEntity employeeEntity);

    EmployeeEntity findById(Long id);

    List<EmployeeEntity> findAllByProjectsId(Long projectId);
}