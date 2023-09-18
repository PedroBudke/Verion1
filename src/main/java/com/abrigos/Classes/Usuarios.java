package com.abrigos.Classes;


import com.abrigos.DTOs.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "usuario_id")

public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     Long        usuario_id;
    private     String      usuario_cpf;
    private     String      usuario_email;
    private     String      usuario_senha;

    public Usuarios(UsuarioRequestDTO data){
        usuario_id      =       data.usuario_id();
        usuario_cpf     =       data.usuario_cpf();
        usuario_email   =       data.usuario_email();
        usuario_senha   =       data.usuario_senha();
    }
}
