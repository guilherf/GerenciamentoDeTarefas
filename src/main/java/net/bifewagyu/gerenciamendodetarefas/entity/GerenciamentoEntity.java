package net.bifewagyu.gerenciamendodetarefas.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "gerenciador_task")
@Data
public class GerenciamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String task;

    @Column
    private String descricao;

    @Column
    private String status;


    @Column
    private String data;

}
