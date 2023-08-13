package br.com.desafio.managementapi.services.impl;

import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.entities.ProjectEntity;
import br.com.desafio.managementapi.exceptions.ProjectException;
import br.com.desafio.managementapi.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Mock
    private ProjectRepository projectRepository;

    @Test
    public void testSaveProject() {
        ProjectEntity project = new ProjectEntity();
        project.setName("Test Project");

        when(projectRepository.save(any(ProjectEntity.class))).thenReturn(project);

        ProjectEntity savedProject = projectService.save(project);

        assertEquals("Test Project", savedProject.getName());
        verify(projectRepository, times(1)).save(project);
    }

    @Test
    public void testFindAllProjects() {
        List<ProjectEntity> projects = new ArrayList<>();
        projects.add(new ProjectEntity());
        projects.add(new ProjectEntity());

        when(projectRepository.findAll()).thenReturn(projects);

        List<ProjectEntity> foundProjects = projectService.findAll();

        assertEquals(2, foundProjects.size());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    public void testFindByEmployees() {
        Long projectId = 1L;
        List<EmployeeEntity> employees = new ArrayList<>();
        employees.add(new EmployeeEntity());
        employees.add(new EmployeeEntity());

        when(projectRepository.findEmployeesByProjectId(projectId)).thenReturn(employees);

        List<EmployeeEntity> foundEmployees = projectService.findByEmployees(projectId);

        assertEquals(2, foundEmployees.size());
        verify(projectRepository, times(1)).findEmployeesByProjectId(projectId);
    }

    @Test
    public void testFindById() {
        Long projectId = 1L;
        ProjectEntity project = new ProjectEntity();
        project.setId(projectId);

        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

        ProjectEntity foundProject = projectService.findById(projectId);

        assertEquals(projectId, foundProject.getId());
        verify(projectRepository, times(1)).findById(projectId);
    }

    @Test(expected = ProjectException.class)
    public void testFindByIdNotFound() {
        Long projectId = 1L;

        when(projectRepository.findById(projectId)).thenReturn(Optional.empty());

        projectService.findById(projectId);
    }
}