package com.math012.agendadortarefas.business.converter;

import com.math012.agendadortarefas.business.dto.TarefaDTO;
import com.math012.agendadortarefas.infra.entity.TarefaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefaEntity paraTarefaEntity(TarefaDTO tarefaDTO);
    TarefaDTO paraTarefaDTO(TarefaEntity tarefaEntity);
    List<TarefaDTO> paraListaTarefaDTO(List<TarefaEntity> tarefa);
    List<TarefaEntity> paraListaTarefaEntity(List<TarefaDTO> tarefaDTO);

}


// Criando os métodos Get 10:22