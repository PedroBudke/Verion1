package com.abrigos.DTOs;

import com.abrigos.Classes.Designacao;

import java.util.Date;

public record DesignacaoResponseDTO(Long        designacao_id,
                                    Long        abrigo_id,
                                    Long        pessoa_id,
                                    Date        designacao_data,
                                    String      designacao_responsavel) {
    public DesignacaoResponseDTO (Designacao designacao){
        this(   designacao.getDesignacao_id(),
                designacao.getAbrigo_id(),
                designacao.getPessoa_id(),
                designacao.getDesignacao_data(),
                designacao.getDesignacao_responsavel()
        );
    }
}
