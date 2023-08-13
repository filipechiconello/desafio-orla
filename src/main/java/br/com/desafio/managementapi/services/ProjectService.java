package br.com.desafio.managementapi.services;

import br.com.desafio.managementapi.entities.ProjectEntity;

import java.util.List;

public interface ProjectService {

    ProjectEntity save(ProjectEntity projectEntity);

    List<ProjectEntity> findAll();
}
