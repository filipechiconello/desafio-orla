package br.com.desafio.managementapi.repositories;

import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

//    @Query("SELECT e FROM employee e JOIN e.projects p WHERE p.id = :projectId")
//    List<EmployeeEntity> findByEmployees(Long projectId);

    List<EmployeeEntity> findByEmployeesContains(Long projectId);
}