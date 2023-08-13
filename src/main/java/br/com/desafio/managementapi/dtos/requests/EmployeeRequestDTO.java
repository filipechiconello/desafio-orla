package br.com.desafio.managementapi.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    private int document;
    private String email;
    private BigDecimal salary;
    private List<Long> projectIds;
}