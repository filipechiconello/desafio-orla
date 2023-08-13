package br.com.desafio.managementapi.controllers;

import br.com.desafio.managementapi.dtos.requests.EmployeeRequestDTO;
import br.com.desafio.managementapi.dtos.responses.EmployeeResponseDTO;
import br.com.desafio.managementapi.facades.EmployeeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> save(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return new ResponseEntity<>(employeeFacade.save(employeeRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<EmployeeResponseDTO>> findAllByProjectsIds(@PathVariable Long projectId) {
        return new ResponseEntity<>(employeeFacade.findAllByProjects_Id(projectId), HttpStatus.OK);
    }
}