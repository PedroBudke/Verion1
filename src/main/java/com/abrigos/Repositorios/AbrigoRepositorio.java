package com.abrigos.Repositorios;

import com.abrigos.Classes.Abrigos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbrigoRepositorio extends JpaRepository<Abrigos,Long> {

    //Método para verificar se o Abrigo esta Ativo.
    @Query("SELECT a FROM abrigos a WHERE a.abrigo_status = 'ativo'")
    List<Abrigos> obterAbrigosAtivos();

    //Método para verificar se o Abrigo esta Inativo.
    @Query("SELECT a FROM abrigos a WHERE  a.abrigo_status = 'inativo'")
    List<Abrigos> obterAbrigosInativos();

    //Método para buscar abrigo pelo nome em Ordem Decresente.
    @Query("SELECT a FROM abrigos a ORDER BY a.abrigo_nome DESC ")
    List<Abrigos> ordemNomeDecrescente();

    //Método para buscar abrigo pelo nome em Ordem crescente.
    @Query("SELECT a FROM abrigos a ORDER BY a.abrigo_nome ASC ")
    List<Abrigos> ordemNomeCrescente();

    //Método para buscar abrigo pela Capacidade em Ordem Cresente.
    @Query("SELECT a FROM abrigos a ORDER BY a.abrigo_capacidade ASC ")
    List<Abrigos> ordemCapacidadeCrescente();

    //Método para buscar abrigo pela Capacidade em Ordem Cresente.
    @Query("SELECT a FROM abrigos a ORDER BY a.abrigo_capacidade DESC ")
    List<Abrigos> ordemCapacidadeDecrescente();

    //Método para buscar abrigo por estado
    @Query("SELECT a FROM abrigos a WHERE a.abrigo_estado = :abrigo_estado")
    List<Abrigos> buscarAbrigoPorEstado(@Param("abrigo_estado") String abrigo_estado);

    //Método para buscar abrigo por responsável
    @Query("SELECT a FROM abrigos a WHERE a.abrigo_responsavel = :abrigo_responsavel")
    List<Abrigos> buscarAbrigoPorResponsavel(@Param("abrigo_responsavel") String abrigo_responsavel);

    //Método para buscar abrigo por nome
    @Query("SELECT a FROM abrigos a WHERE a.abrigo_nome = :abrigo_nome")
    List<Abrigos> buscarAbrigoPorNome(@Param("abrigo_nome") String abrigo_nome);

    //Método para buscar abrigo por Cidade
    @Query("SELECT a FROM abrigos a WHERE a.abrigo_cidade = :abrigo_cidade")
    List<Abrigos> buscarAbrigoPorCidade(@Param("abrigo_cidade") String abrigo_cidade);
}
