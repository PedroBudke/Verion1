package com.abrigos.Repositorios;

import com.abrigos.Classes.Abrigos;
import com.abrigos.Classes.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepositorio extends JpaRepository<Pessoas,Long> {

    //Método para buscar pessoa pela em Ordem Cresente.
    @Query("SELECT p FROM pessoas p ORDER BY p.pessoa_nome ASC ")
    List<Pessoas> ordemNomeCrescente();

    //Método para buscar pessoa pela em Ordem Cresente.
    @Query("SELECT p FROM pessoas p ORDER BY p.pessoa_nome DESC ")
    List<Pessoas> ordemNomeDecrescente();

    //Método para buscar pessoa pelo CPF
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_cpf = :pessoa_cpf")
    List<Pessoas> buscarPessoaPorCPF(@Param("pessoa_cpf") String pessoa_cpf);

    //Método para buscar pessoa pelo Nome
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_nome = :pessoa_nome")
    List<Pessoas> buscarPessoaPorNome(@Param("pessoa_nome") String pessoa_nome);

    //Método para buscar pessoa pelo Contato
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_contato = :pessoa_contato")
    List<Pessoas> buscarPessoaPorContato(@Param("pessoa_contato") String pessoa_contato);

    //Método para buscar pessoa pelo Email
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_email = :pessoa_email")
    List<Pessoas> buscarPessoaPorEmail(@Param("pessoa_email") String pessoa_email);

    //Método para buscar pessoa pelo Genero
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_genero = :pessoa_genero")
    List<Pessoas> buscarPessoaPorGenero(@Param("pessoa_genero") String pessoa_genero);

    //Método para buscar pessoa pelo CEP
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_cep = :pessoa_cep")
    List<Pessoas> buscarPessoaPorCep(@Param("pessoa_cep") String pessoa_cep);

    //Método para buscar pessoa pelo Rua
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_rua = :pessoa_rua")
    List<Pessoas> buscarPessoaPorRua(@Param("pessoa_rua") String pessoa_rua);

    //Método para buscar pessoa pelo Bairro
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_bairro = :pessoa_bairro")
    List<Pessoas> buscarPessoaPorBairro(@Param("pessoa_bairro") String pessoa_bairro);

    //Método para buscar pessoa pelo Cidade
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_cidade = :pessoa_cidade")
    List<Pessoas> buscarPessoaPorCidade(@Param("pessoa_cidade") String pessoa_cidade);

    //Método para buscar pessoa pelo Estado
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_estado = :pessoa_estado")
    List<Pessoas> buscarPessoaPorEstado(@Param("pessoa_estado") String pessoa_estado);

    //Método para buscar pessoa pelo Usuario
    @Query("SELECT p FROM pessoas p WHERE p.pessoa_usuario = :pessoa_usuario")
    List<Pessoas> buscarPessoaPorUsuario(@Param("pessoa_usuario") String pessoa_usuario);

}
