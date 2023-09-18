package com.abrigos.Classes;

import com.abrigos.DTOs.PessoaRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Table(name = "pessoas")
@Entity(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pessoa_id")

public class Pessoas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     Long        pessoa_id;
    private     String      pessoa_cpf;
    private     String      pessoa_nome;
    private     String      pessoa_contato;
    private     String      pessoa_email;
    private     String      pessoa_genero;
    private     Date        data_nascimento;
    private     String      pessoa_cep;
    private     String      pessoa_rua;
    private     String      pessoa_bairro;
    private     String      pessoa_cidade;
    private     String      pessoa_estado;
    private     Integer     pessoa_nr_residencia;
    private     String      pessoa_usuario;
    private     String      pessoa_senha;

    public Pessoas(PessoaRequestDTO data){

        pessoa_id               =       data.pessoa_id();
        pessoa_cpf              =       data.pessoa_cpf();
        pessoa_nome             =       data.pessoa_nome();
        pessoa_contato          =       data.pessoa_contato();
        pessoa_email            =       data.pessoa_email();
        pessoa_genero           =       data.pessoa_genero();
        data_nascimento         =       data.data_nascimento();
        pessoa_cep              =       data.pessoa_cep();
        pessoa_rua              =       data.pessoa_rua();
        pessoa_bairro           =       data.pessoa_bairro();
        pessoa_cidade           =       data.pessoa_cidade();
        pessoa_estado           =       data.pessoa_estado();
        pessoa_nr_residencia    =       data.pessoa_nr_residencia();
        pessoa_usuario          =       data.pessoa_usuario();
        pessoa_senha            =       data.pessoa_senha();

    }
}
