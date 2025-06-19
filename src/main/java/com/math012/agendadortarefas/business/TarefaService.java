package com.math012.agendadortarefas.business;

import com.math012.agendadortarefas.business.converter.TarefaConverter;
import com.math012.agendadortarefas.business.dto.TarefaDTO;
import com.math012.agendadortarefas.infra.entity.enums.StatusTarefa;
import com.math012.agendadortarefas.infra.repository.TarefaRepository;
import com.math012.agendadortarefas.infra.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TarefaService {


    private final TarefaRepository tarefaRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefaDTO gravarTarefa(TarefaDTO tarefaDTO, String token){
        tarefaDTO.setEmailUsuario(jwtUtil.extrairEmailToken(token.substring(7)));
        tarefaDTO.setDataCriacao(LocalDateTime.now());
        tarefaDTO.setStatusTarefa(StatusTarefa.PENDENTE);
        return tarefaConverter.paraTarefaDTO(tarefaRepository.save(
                tarefaConverter.paraTarefaEntity(tarefaDTO)));
    }

    public List<TarefaDTO> buscarTarefaAgendadaPorPeriado(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return tarefaConverter.paraListaTarefaDTO(tarefaRepository.findByDataEventoBetween(dataInicial,dataFinal));
    }

    public List<TarefaDTO> buscarTarefaPorEmail(String token){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        return tarefaConverter.paraListaTarefaDTO(tarefaRepository.findByEmailUsuario(email));
    }

}
