package br.com.desafio.managementapi.services.impl;

import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.entities.ProjectEntity;
import br.com.desafio.managementapi.repositories.ProjectRepository;
import br.com.desafio.managementapi.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectEntity save(ProjectEntity projectEntity) {
        log.info("creating new project - {}", projectEntity);
        return projectRepository.save(projectEntity);
    }

    @Override
    public List<ProjectEntity> findAll() {
        log.info("listing all projects");
        return projectRepository.findAll();
    }

    @Override
    public List<EmployeeEntity> findByEmployees(Long projectId) {
        log.info("listing employees by project id - {}", projectId);
        return projectRepository.findEmployeesByProjectId(projectId);
    }

    @Override
    public ProjectEntity findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("erro"));
    }
}