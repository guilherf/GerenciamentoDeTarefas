package net.bifewagyu.gerenciamendodetarefas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GerenciamentoRequest(@NotBlank(message = "O título da tarefa não pode estar em branco")
                                   String task,
                                   @Size(min = 10, message = "A descrição deve ter no minimo 10 caracteres")
                                   String descricao) {




}
