package net.bifewagyu.gerenciamendodetarefas.controllers;


import jakarta.validation.Valid;
import net.bifewagyu.gerenciamendodetarefas.dtos.GerenciamentoRequest;
import net.bifewagyu.gerenciamendodetarefas.dtos.GerenciamentoResponse;
import net.bifewagyu.gerenciamendodetarefas.services.GerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GerenciamentoController {

    @Autowired
    private final GerenciamentoService service;

    public GerenciamentoController(GerenciamentoService service) {
        this.service = service;
    }


    @GetMapping("/alltask")
    public ResponseEntity<List<GerenciamentoResponse>> getGerenciamentos() {



        return ResponseEntity.ok(service.todasAstask());



    }



    @PostMapping("/savetask")
    public ResponseEntity<GerenciamentoResponse> salvarGerenciamento(@RequestBody @Valid GerenciamentoRequest request) {

        GerenciamentoResponse response = service.salvar(request);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @GetMapping("buscarTaskId/{id}")
    public ResponseEntity<GerenciamentoResponse> getGerenciamentoById(@PathVariable Long id) {

        GerenciamentoResponse response = service.consultar(id);

        return ResponseEntity.ok(response);

    }


    @DeleteMapping("deletarPorId/{id}")
    public void deletarPorId(@PathVariable long id) {

        service.deletarPorId(id);

    }



    @PutMapping("concluirTask/{id}")
    public ResponseEntity<GerenciamentoResponse> concluirGerenciamento(@PathVariable Long id) {

        GerenciamentoResponse response = service.concluirTask(id);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);




    }


















}
