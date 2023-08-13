package br.com.desafio.managementapi.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EmployeeEnum {

    EMPLOYEE_NOT_FOUND("MTAA001", "Employee not found", 404);

    private String code;
    private String message;
    private Integer statusCode;
}