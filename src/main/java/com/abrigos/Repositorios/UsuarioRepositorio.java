package com.abrigos.Repositorios;

import com.abrigos.Classes.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long> {

    //Método para buscar Usuario pelo CPF
    @Query("SELECT u FROM usuarios u WHERE u.usuario_cpf = :usuario_cpf")
    List<Usuarios> buscarUsuarioPorCPF(@Param("usuario_cpf") String usuario_cpf);

    //Método para buscar Usuario pelo Email
    @Query("SELECT u FROM usuarios u WHERE u.usuario_email = :usuario_email")
    List<Usuarios> buscarUsuarioPorEmail(@Param("usuario_email") String usuario_email);
}
