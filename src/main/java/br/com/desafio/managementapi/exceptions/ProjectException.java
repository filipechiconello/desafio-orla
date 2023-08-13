package br.com.desafio.managementapi.exceptions;

import br.com.desafio.managementapi.exceptions.enums.ProjectEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ProjectException extends ManagementException {

    private static final long serialVersionUID = -4589179341768493322L;

    public ProjectException(ProjectEnum error) {
        super(error.getMessage());
        this.error = error;
    }

    private final ProjectEnum error;
}
