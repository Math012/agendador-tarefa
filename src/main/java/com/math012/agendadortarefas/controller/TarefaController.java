package com.math012.agendadortarefas.controller;

import com.math012.agendadortarefas.business.TarefaService;
import com.math012.agendadortarefas.business.dto.TarefaDTO;
import com.math012.agendadortarefas.infra.entity.TarefaEntity;
import com.math012.agendadortarefas.infra.entity.enums.StatusTarefa;
import jdk.jshell.Snippet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaDTO> gravarTarefa(@RequestBody TarefaDTO tarefaDTO, @RequestHeader("Authorization")String token){
        return ResponseEntity.ok(tarefaService.gravarTarefa(tarefaDTO,token));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefaDTO>> buscarListaTarefaPorPeriado(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal){
        return ResponseEntity.ok(tarefaService.buscarTarefaAgendadaPorPeriado(dataInicial,dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTarefaPorEmail(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefaService.buscarTarefaPorEmail(token));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("idTarefa")String id){
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/status")
    public ResponseEntity<TarefaDTO> alteraStatusNotificacao(@RequestParam("status")StatusTarefa statusTarefa,
                                                             @RequestParam("idTarefa")String id){
        return ResponseEntity.ok(tarefaService.alteraStatusTarefa(statusTarefa,id));
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> updateDeTarefa(@RequestBody TarefaDTO tarefaDTO,
                                                    @RequestParam("idTarefa")String id){
        return ResponseEntity.ok(tarefaService.updateTarefa(tarefaDTO,id));
    }
}
