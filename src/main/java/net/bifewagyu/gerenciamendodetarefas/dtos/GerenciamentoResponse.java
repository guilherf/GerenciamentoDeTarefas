package net.bifewagyu.gerenciamendodetarefas.dtos;

public record GerenciamentoResponse(Long id,
                                    String task,
                                    String descricao,
                                    String status,
                                    String data) {
}
