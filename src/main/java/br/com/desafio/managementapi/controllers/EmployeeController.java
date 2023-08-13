package br.com.desafio.managementapi.controllers;

import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> finById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<EmployeeEntity>> get(@PathVariable Long projectId) {
        return new ResponseEntity<>(employeeService.findAllByProjects_Id(projectId), HttpStatus.OK);
    }
}