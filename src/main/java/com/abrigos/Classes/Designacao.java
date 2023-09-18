package com.abrigos.Classes;

import com.abrigos.DTOs.DesignacaoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "designacao")
@Entity(name = "designacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Designacao {

    @Id @GeneratedValue    (strategy = GenerationType.IDENTITY)
    private         Long        designacao_id; //Adicionar no Banco
    private         Long        abrigo_id;
    private         Long        pessoa_id;
    private         Date        designacao_data;
    private         String      designacao_responsavel;

    public Designacao(DesignacaoRequestDTO data){

        designacao_id               =       data.designacao_id();
        abrigo_id                   =       data.abrigo_id();
        pessoa_id                   =       data.pessoa_id();
        designacao_data             =       data.designacao_data();
        designacao_responsavel      =       data.designacao_responsavel();

    }
}
