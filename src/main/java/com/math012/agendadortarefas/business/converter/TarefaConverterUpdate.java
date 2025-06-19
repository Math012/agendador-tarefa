package com.math012.agendadortarefas.business.converter;

import com.math012.agendadortarefas.business.dto.TarefaDTO;
import com.math012.agendadortarefas.infra.entity.TarefaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaConverterUpdate {

    // Se DTO estiver nulo, considerar o valor da TarefaEntity
    void updateTarefa(TarefaDTO tarefaDTO, @MappingTarget TarefaEntity tarefaEntity);
}
