package net.bifewagyu.gerenciamendodetarefas.services;


import net.bifewagyu.gerenciamendodetarefas.apiconfig.GerenciamentoConfig;
import net.bifewagyu.gerenciamendodetarefas.dtos.GerenciamentoRequest;
import net.bifewagyu.gerenciamendodetarefas.dtos.GerenciamentoResponse;
import net.bifewagyu.gerenciamendodetarefas.entity.GerenciamentoEntity;
import net.bifewagyu.gerenciamendodetarefas.reporsitory.GerenciamentoRepository;
import net.bifewagyu.gerenciamendodetarefas.status.GerenciamentoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class GerenciamentoService {

    @Autowired
    private final GerenciamentoRepository gerenciamentoRepository;

    @Autowired
    private final GerenciamentoConfig gerenciamentoConfig;

    public GerenciamentoService(GerenciamentoRepository gerenciamentoRepository, GerenciamentoConfig gerenciamentoConfig) {
        this.gerenciamentoRepository = gerenciamentoRepository;
        this.gerenciamentoConfig = gerenciamentoConfig;
    }


    public List<GerenciamentoResponse> todasAstask() {

        List<GerenciamentoEntity> gerenciamentos = gerenciamentoRepository.findAll();

        return gerenciamentos.stream().map(entity -> new GerenciamentoResponse(
                entity.getId(),
                entity.getTask(),
                entity.getDescricao(),
                entity.getStatus(),
                entity.getData()
        )).toList();

    }


    public GerenciamentoResponse salvar(GerenciamentoRequest request) {
        GerenciamentoEntity entity = new GerenciamentoEntity();


        entity.setTask(request.task());
        entity.setDescricao(request.descricao());
        entity.setStatus(GerenciamentoStatus.ABERTO.toString());
        entity.setData(LocalDateTime.now().format(gerenciamentoConfig.dataformatter()));

        GerenciamentoEntity gerenciamentoEntity = gerenciamentoRepository.save(entity);


        return new GerenciamentoResponse(gerenciamentoEntity.getId(),gerenciamentoEntity.getTask(),
                gerenciamentoEntity.getDescricao(),gerenciamentoEntity.getStatus(),gerenciamentoEntity.getData()
                );
    }


    public void deletarPorId(long id) {
        gerenciamentoRepository.deleteById(id);

    }



    public GerenciamentoResponse consultar(Long id) {

        GerenciamentoEntity entity = gerenciamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID:" + id));

        return new GerenciamentoResponse(entity.getId(), entity.getTask(), entity.getDescricao(), entity.getStatus(),entity.getData());


    }

    @Transactional
    public GerenciamentoResponse concluirTask(Long id) {

        GerenciamentoEntity entity = gerenciamentoRepository.findById(id).orElseThrow( () -> new RuntimeException("Erro ao concluir o task"));


        entity.setStatus(GerenciamentoStatus.CONCLUIDO.toString());
        entity.setData(LocalDateTime.now().format(gerenciamentoConfig.dataformatter()));

        return new GerenciamentoResponse(entity.getId(), entity.getTask(), entity.getDescricao(), entity.getData(), entity.getStatus());

    }

}
