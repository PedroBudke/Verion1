package com.abrigos.Classes;

import com.abrigos.DTOs.AbrigoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "abrigos")
@Entity(name = "abrigos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "abrigo_id")

public class Abrigos {

    @Id          @GeneratedValue    (strategy = GenerationType.IDENTITY)
    private     Long        abrigo_id;
    private     String      abrigo_nome;
    private     String      abrigo_contato;
    private     String      abrigo_cep;//MUDAR NO BANCO PARA VARCHAR
    private     String      abrigo_rua;
    private     String      abrigo_bairro;
    private     String      abrigo_cidade;
    private     String      abrigo_estado;
    private     Integer     abrigo_nr_abrigos;
    private     String      abrigo_status;
    private     Integer     abrigo_capacidade;
    private     String      abrigo_responsavel;

    public Abrigos (AbrigoRequestDTO data){

        abrigo_id                   =           data.abrigo_id();
        abrigo_nome                 =           data.abrigo_nome();
        abrigo_contato              =           data.abrigo_contato();
        abrigo_cep                  =           data.abrigo_cep();
        abrigo_rua                  =           data.abrigo_rua();
        abrigo_bairro               =           data.abrigo_bairro();
        abrigo_cidade               =           data.abrigo_cidade();
        abrigo_estado               =           data.abrigo_estado();
        abrigo_nr_abrigos           =           data.abrigo_nr_abrigos();
        abrigo_status               =           data.abrigo_status();
        abrigo_capacidade           =           data.abrigo_capacidade();
        abrigo_responsavel          =           data.abrigo_responsavel();

    }
}
