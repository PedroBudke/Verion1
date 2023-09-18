package com.abrigos.Classes;

import com.abrigos.DTOs.AtendimentoRequstDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Table(name = "atendimentos")
@Entity(name = "atendimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "atendimento_id")
public class Atendimentos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private         Long        atendimento_id;
    private         Long        abrigo_id;
    private         Long        pessoa_id;
    private         Date        atendimento_data;
    private         String      observacao;
    private         String      tomada_decisao;
    private         String      atendimento_responsavel;

    public Atendimentos(AtendimentoRequstDTO data){
        atendimento_id              =           data.atendimento_id();
        abrigo_id                   =           data.abrigo_id();
        pessoa_id                   =           data.pessoa_id();
        atendimento_data            =           data.atendimento_data();
        observacao                  =           data.observacao();
        tomada_decisao              =           data.tomada_decisao();
        atendimento_responsavel     =           data.atendimento_responsavel();
    }

}
