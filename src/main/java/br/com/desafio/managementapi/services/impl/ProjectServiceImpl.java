package br.com.desafio.managementapi.services.impl;

import br.com.desafio.managementapi.entities.ProjectEntity;
import br.com.desafio.managementapi.repositories.ProjectRepository;
import br.com.desafio.managementapi.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Override
    public ProjectEntity save(ProjectEntity projectEntity) {
        logger.info("creating new project - {}", projectEntity);
        return projectRepository.save(projectEntity);
    }

    @Override
    public List<ProjectEntity> findAll() {
        logger.info("listing all projects");
        return projectRepository.findAll();
    }
}