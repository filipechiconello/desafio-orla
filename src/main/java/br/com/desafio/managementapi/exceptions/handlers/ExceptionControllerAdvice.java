package br.com.desafio.managementapi.exceptions.handlers;

import br.com.desafio.managementapi.exceptions.ProjectException;
import br.com.desafio.managementapi.exceptions.EmployeeException;
import br.com.desafio.managementapi.exceptions.models.ErrorObject;
import br.com.desafio.managementapi.exceptions.models.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        log.error("data entry error: {}", errorResponse);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse(Instant.now().toEpochMilli(), status.value(), status.getReasonPhrase(), status.getReasonPhrase(), errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @ExceptionHandler(ProjectException.class)
    ResponseEntity<ErrorResponse> handlerAuthenticationException(ProjectException ex) {
        return ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(EmployeeException.class)
    ResponseEntity<ErrorResponse> handlerNotificationException(EmployeeException ex) {
        return ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }
}