package com.github.diegolins10.clientapi.api.middleware;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.diegolins10.clientapi.api.responses.RestResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<RestResult<Void>> handleDatabaseError() {
        return ResponseEntity.badRequest()
                .body(RestResult.error("Dados inválidos"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResult<Void>> handleGenericError(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(RestResult.error("Erro interno: " + ex.getMessage()));
    }
}
