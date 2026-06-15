package net.bifewagyu.gerenciamendodetarefas.exepicios;


import net.bifewagyu.gerenciamendodetarefas.dtos.DadosErros;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ApiError {



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErros>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<DadosErros> dadosErros = fieldErrors.stream().map(DadosErros::new).toList();


        return ResponseEntity.badRequest().body(dadosErros);



    }





}
