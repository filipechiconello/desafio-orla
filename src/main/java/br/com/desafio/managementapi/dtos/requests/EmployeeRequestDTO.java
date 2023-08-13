package br.com.desafio.managementapi.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    @Size(min = 11, max = 11, message = "{document.validation}")
    private int document;

    @Email(message = "{email.validation}")
    @NotEmpty(message = "{not.empty}")
    private String email;

    @NotNull(message = "{not.null}")
    private BigDecimal salary;

    private List<Long> projectIds;
}