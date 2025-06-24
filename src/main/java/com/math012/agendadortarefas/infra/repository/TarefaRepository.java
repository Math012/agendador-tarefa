package com.math012.agendadortarefas.infra.repository;

import com.math012.agendadortarefas.infra.entity.TarefaEntity;
import com.math012.agendadortarefas.infra.entity.enums.StatusTarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefaRepository extends MongoRepository<TarefaEntity, String> {

    List<TarefaEntity> findByDataEventoBetweenAndStatusTarefa(LocalDateTime dataInicial, LocalDateTime dataFinal, StatusTarefa statusTarefa);
    List<TarefaEntity> findByEmailUsuario(String email);
}
