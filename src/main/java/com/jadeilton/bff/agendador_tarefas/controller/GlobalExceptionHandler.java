package com.jadeilton.bff.agendador_tarefas.controller;


import com.jadeilton.bff.agendador_tarefas.infrastructure.exceptions.ConflictException;
import com.jadeilton.bff.agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.jadeilton.bff.agendador_tarefas.infrastructure.exceptions.UnauthorizedException;
import com.jadeilton.bff.agendador_tarefas.infrastructure.exceptions.IllegalArgumentException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {




    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handlerResouceNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handlerConflictException(ConflictException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }




    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> UnauthorizedException(ConflictException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
