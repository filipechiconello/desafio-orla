package br.com.desafio.managementapi.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {

    @NotNull(message = "{not.null}")
    @NotEmpty(message = "{not.empty}")
    private String name;

    @NotNull(message = "{not.null}")
    @NotEmpty(message = "{not.empty}")
    private LocalDateTime createdAt;

    private List<Long> employeeIds;
}