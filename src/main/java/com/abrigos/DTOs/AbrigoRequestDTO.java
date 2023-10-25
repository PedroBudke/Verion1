package com.abrigos.DTOs;

import java.util.Date;

public record AbrigoRequestDTO(Long        abrigo_id,
                               String      abrigo_nome,
                               String      abrigo_contato,
                               Date        abrigo_inauguracao,
                               String      abrigo_cep,
                               String      abrigo_rua,
                               String      abrigo_bairro,
                               String      abrigo_cidade,
                               String      abrigo_estado,
                               Integer     abrigo_nr_abrigos,
                               String      abrigo_status,
                               Integer     abrigo_capacidade,
                               String      abrigo_responsavel) {
}
