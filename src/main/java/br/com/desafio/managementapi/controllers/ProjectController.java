package br.com.desafio.managementapi.controllers;

import br.com.desafio.managementapi.dtos.requests.ProjectRequestDTO;
import br.com.desafio.managementapi.dtos.responses.ProjectResponseDTO;
import br.com.desafio.managementapi.entities.EmployeeEntity;
import br.com.desafio.managementapi.facades.ProjectFacade;
import br.com.desafio.managementapi.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectFacade projectFacade;

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> findAll() {
        return new ResponseEntity<>(projectFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> save(@Valid @RequestBody ProjectRequestDTO projectRequestDTO) {
        return new ResponseEntity<>(projectFacade.save(projectRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<EmployeeEntity>> findByEmployeesByProjectId(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectService.findByEmployees(projectId), HttpStatus.OK);
    }
}