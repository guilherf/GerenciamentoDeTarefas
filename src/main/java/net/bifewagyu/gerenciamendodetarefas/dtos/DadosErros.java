package net.bifewagyu.gerenciamendodetarefas.dtos;

import org.springframework.validation.FieldError;

public record DadosErros(String task,
                         String descricao) {

    public DadosErros(FieldError fieldError) {
        this(fieldError.getDefaultMessage(), fieldError.getField());
    }



}
