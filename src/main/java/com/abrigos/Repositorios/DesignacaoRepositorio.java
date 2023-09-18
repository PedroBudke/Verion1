package com.abrigos.Repositorios;

import com.abrigos.Classes.Designacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesignacaoRepositorio extends JpaRepository<Designacao, Long> {

    @Query("SELECT d FROM designacao d WHERE d.abrigo_id = :abrigo_id")
    List<Designacao> buscarDesignacaoPorAbrigo(@Param("abrigo_id") Long abrigo_id);

    @Query("SELECT d FROM designacao d WHERE d.pessoa_id = :pessoa_id")
    List<Designacao> buscarDesignacaoPorPessoa(@Param("pessoa_id") Long pessoa_id);

    @Query("SELECT d FROM designacao d WHERE d.designacao_responsavel = :designacao_responsavel")
    List<Designacao> buscarDesignacaoPorResponsavel(@Param("designacao_responsavel") String designacao_responsavel);

}
