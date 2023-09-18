package com.abrigos.DTOs;

import java.util.Date;

public record AtendimentoRequstDTO(Long        atendimento_id,
                                   Long        abrigo_id,
                                   Long        pessoa_id,
                                   Date         atendimento_data,
                                   String      observacao,
                                   String      tomada_decisao,
                                   String      atendimento_responsavel) {
}
