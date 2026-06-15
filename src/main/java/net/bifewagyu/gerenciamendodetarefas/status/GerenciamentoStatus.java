package net.bifewagyu.gerenciamendodetarefas.status;

public enum GerenciamentoStatus {

    ANDAMENTO("EM ANDAMENTO"),
    FECHADO("FECHADO"),
    ABERTO("ABERTO"),
    INDISPONIVEL("INDISPONIVEL"),
    CONCLUIDO("CONCLUIDO");




    private String value;

    public String getValue() {
        return value;
    }

    GerenciamentoStatus(String value) {
        this.value = value;
    }

}
