package com.math012.agendadortarefas.business.converter;

import com.math012.agendadortarefas.business.dto.TarefaDTO;
import com.math012.agendadortarefas.infra.entity.TarefaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefaEntity paraTarefaEntity(TarefaDTO tarefaDTO);
    TarefaDTO paraTarefaDTO(TarefaEntity tarefaEntity);
}
