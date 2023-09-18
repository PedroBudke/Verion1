package com.abrigos.DTOs;

import java.util.Date;

public record PessoaRequestDTO(Long pessoa_id,
                               String pessoa_cpf,
                               String pessoa_nome,
                               String pessoa_contato,
                               String pessoa_email,
                               String pessoa_genero,
                               Date data_nascimento,
                               String pessoa_cep,
                               String pessoa_rua,
                               String pessoa_bairro,
                               String pessoa_cidade,
                               String pessoa_estado,
                               Integer pessoa_nr_residencia,
                               String pessoa_usuario,
                               String pessoa_senha) {
}
