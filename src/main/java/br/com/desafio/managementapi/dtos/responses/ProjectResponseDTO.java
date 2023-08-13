package br.com.desafio.managementapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {

    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private List<EmployeeResponseDTO> employees;
}