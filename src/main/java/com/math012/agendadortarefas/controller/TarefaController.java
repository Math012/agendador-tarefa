package com.math012.agendadortarefas.controller;

import com.math012.agendadortarefas.business.TarefaService;
import com.math012.agendadortarefas.business.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaDTO> gravarTarefa(@RequestBody TarefaDTO tarefaDTO,
                                                  @RequestHeader("Authorization")String token){
        return ResponseEntity.ok(tarefaService.gravarTarefa(tarefaDTO,token));
    }

}
