package com.abrigos.DTOs;

import com.abrigos.Classes.Usuarios;

public record UsuarioResponseDTO (Long usuario_id,
                                String usuario_cpf,
                                String usuario_email,
                                String usuario_senha) {
                public UsuarioResponseDTO (Usuarios usuarios) {
                    this(usuarios.getUsuario_id(),
                            usuarios.getUsuario_cpf(),
                            usuarios.getUsuario_email(),
                            usuarios.getUsuario_senha()
                    );
                }
            }


