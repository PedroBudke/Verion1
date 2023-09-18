package com.abrigos.DTOs;

import com.abrigos.Classes.Pessoas;

import java.util.Date;

public record PessoaResponseDTO(Long pessoa_id,
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

    public PessoaResponseDTO (Pessoas pessoas) {
        this(   pessoas.getPessoa_id(),
                pessoas.getPessoa_cpf(),
                pessoas.getPessoa_nome(),
                pessoas.getPessoa_contato(),
                pessoas.getPessoa_email(),
                pessoas.getPessoa_genero(),
                pessoas.getData_nascimento(),
                pessoas.getPessoa_cep(),
                pessoas.getPessoa_rua(),
                pessoas.getPessoa_bairro(),
                pessoas.getPessoa_cidade(),
                pessoas.getPessoa_estado(),
                pessoas.getPessoa_nr_residencia(),
                pessoas.getPessoa_usuario(),
                pessoas.getPessoa_senha()
        );
    }
}
