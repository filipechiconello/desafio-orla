package br.com.desafio.managementapi.controllers;

import br.com.desafio.managementapi.dtos.requests.ProjectRequestDTO;
import br.com.desafio.managementapi.dtos.responses.ProjectResponseDTO;
import br.com.desafio.managementapi.facades.ProjectFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectFacade projectFacade;

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> findAll() {
        return new ResponseEntity<>(projectFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> save(@RequestBody ProjectRequestDTO projectRequestDTO) {
        return new ResponseEntity<>(projectFacade.save(projectRequestDTO), HttpStatus.CREATED);
    }
}
