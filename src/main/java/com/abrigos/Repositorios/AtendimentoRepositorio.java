package com.abrigos.Repositorios;

import com.abrigos.Classes.Atendimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AtendimentoRepositorio extends JpaRepository<Atendimentos,Long> {

    //Método para buscar atendimento por responsável
    @Query("SELECT a FROM atendimentos a WHERE a.atendimento_responsavel = :atendimento_responsavel")
    List<Atendimentos> buscarAtendimentoPorResponsavel(@Param("atendimento_responsavel") String atendimento_responsavel);

    //Método para buscar atendimento por abrigo
    @Query("SELECT a FROM atendimentos a WHERE a.abrigo_id = :abrigo_id")
    List<Atendimentos> buscarAtendimentoPorAbrigo(@Param("abrigo_id") Long abrigo_id);

    //Método para buscar atendimento por pessoa
    @Query("SELECT a FROM atendimentos a WHERE a.pessoa_id = :pessoa_id")
    List<Atendimentos> buscarAtendimentoPorPessoa(@Param("pessoa_id") Long pessoa_id);
}
