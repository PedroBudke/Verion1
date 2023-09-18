package com.abrigos.DTOs;

import com.abrigos.Classes.Atendimentos;

import java.util.Date;

public record AtendimentoResponseDTO (Long        atendimento_id,
                                     Long        abrigo_id,
                                     Long        pessoa_id,
                                     Date       atendimento_data,
                                     String      observacao,
                                     String      tomada_decisao,
                                     String      atendimento_responsavel){

    public AtendimentoResponseDTO (Atendimentos atendimentos){
        this(   atendimentos.getAtendimento_id(),
                atendimentos.getAbrigo_id(),
                atendimentos.getPessoa_id(),
                atendimentos.getAtendimento_data(),
                atendimentos.getObservacao(),
                atendimentos.getTomada_decisao(),
                atendimentos.getAtendimento_responsavel()
        );
    }

}
