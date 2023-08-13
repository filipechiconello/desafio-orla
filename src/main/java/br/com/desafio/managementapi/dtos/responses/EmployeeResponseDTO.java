package br.com.desafio.managementapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {

    private Long id;
    private String document;
    private String email;
    private BigDecimal salary;
    private List<ProjectResponseDTO> projects;
}
