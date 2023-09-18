package com.abrigos.DTOs;

import java.util.Date;

public record DesignacaoRequestDTO(Long designacao_id,
                                   Long     abrigo_id,
                                   Long     pessoa_id,
                                   Date     designacao_data,
                                   String   designacao_responsavel) {
}
