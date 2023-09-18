package com.abrigos.DTOs;

public record UsuarioRequestDTO (Long usuario_id,
                                String usuario_cpf,
                                String usuario_email,
                                String usuario_senha) {
}
