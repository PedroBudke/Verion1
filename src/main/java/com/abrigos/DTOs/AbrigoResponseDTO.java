package com.abrigos.DTOs;

import com.abrigos.Classes.Abrigos;

public record AbrigoResponseDTO(Long        abrigo_id,
                                String      abrigo_nome,
                                String      abrigo_contato,
                                String      abrigo_cep,
                                String      abrigo_rua,
                                String      abrigo_bairro,
                                String      abrigo_cidade,
                                String      abrigo_estado,
                                Integer     abrigo_nr_abrigos,
                                String     abrigo_status,
                                Integer     abrigo_capacidade,
                                String      abrigo_responsavel) {

    public AbrigoResponseDTO (Abrigos abrigos){
        this(   abrigos.getAbrigo_id(),
                abrigos.getAbrigo_nome(),
                abrigos.getAbrigo_contato(),
                abrigos.getAbrigo_cep(),
                abrigos.getAbrigo_rua(),
                abrigos.getAbrigo_bairro(),
                abrigos.getAbrigo_cidade(),
                abrigos.getAbrigo_estado(),
                abrigos.getAbrigo_nr_abrigos(),
                abrigos.getAbrigo_status(),
                abrigos.getAbrigo_capacidade(),
                abrigos.getAbrigo_responsavel()
        );
    }
}
