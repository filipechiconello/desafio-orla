package br.com.desafio.managementapi.services.impl;

import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.entities.ProjectEntity;
import br.com.desafio.managementapi.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private final Long ID = 1L;
    private final LocalDate DATE = LocalDate.now();

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        when(employeeRepository.findById(ID)).thenReturn(Optional.of(returnEmployeeEntity()));
        when(employeeRepository.save(returnEmployeeEntity())).thenReturn(returnEmployeeEntity());
        when(employeeRepository.findAllByProjects_Id(ID)).thenReturn(returnList());
    }

    @Test
    public void saveMustReturnOk() throws Exception {
        assertEquals(returnEmployeeEntity(), employeeService.save(returnEmployeeEntity()));
    }

    @Test
    public void findByIdMustReturnOk() throws Exception {
        assertEquals(returnEmployeeEntity(), employeeService.findById(ID));
    }

    @Test
    public void findAllByProjects_Id() throws Exception {
        assertEquals(returnList(), employeeService.findAllByProjectsId(ID));
    }

    private List<EmployeeEntity> returnList() {
        return new ArrayList<>();
    }

    private List<ProjectEntity> reuturnListProjects() {
        List<ProjectEntity> list = new ArrayList<>();
        list.add(returnProjectEntity());

        return list;
    }


    private ProjectEntity returnProjectEntity() {
        return new ProjectEntity(
                ID,
                "name",
                DATE,
                returnList()
        );
    }

    private EmployeeEntity returnEmployeeEntity() {
        return new EmployeeEntity(
                ID,
                "12345678901",
                "email@email.com.br",
                new BigDecimal("100.00"),
                reuturnListProjects()
        );
    }
}