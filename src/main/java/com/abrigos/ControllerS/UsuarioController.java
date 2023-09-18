package com.abrigos.ControllerS;

import com.abrigos.Classes.Usuarios;
import com.abrigos.DTOs.UsuarioRequestDTO;
import com.abrigos.DTOs.UsuarioResponseDTO;
import com.abrigos.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    //INSERIR PESSOA
    @PostMapping
    public Usuarios inserirUsuario(@RequestBody UsuarioRequestDTO data){
        Usuarios usuarioData = new Usuarios(data);
        return usuarioRepositorio.save(usuarioData);
    }

    //BUSCAR TODOS USUARIOS CADASTRADOS
    @GetMapping("/todos")
    public List<UsuarioResponseDTO> getAList(){
        List<UsuarioResponseDTO> responseDTOS = usuarioRepositorio.findAll().stream().map(UsuarioResponseDTO::new).toList();
        return responseDTOS;
    }

    //BUSCAR USUARIO POR ID
    @GetMapping("/{usuario_id}")
    public Usuarios buscarUsuario(@PathVariable("usuario_id")Long id) {
        Usuarios usuario = usuarioRepositorio.findById(id).orElse(null);
        return usuario;
    }

    //DELETAR USUARIO POR ID
    @DeleteMapping("/{usuario_id}")
    public Usuarios excluirUsuario(@PathVariable("usuario_id")Long id) {
        Usuarios usuario = usuarioRepositorio.findById(id).orElse(null);
        if (usuario != null) {
            usuarioRepositorio.deleteById(id);
        }
        return usuario;
    }

    //ALTERAR USUARIO
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping
    public Usuarios alterarUsuario(@RequestBody UsuarioRequestDTO data) {
        Usuarios usuario = new Usuarios(data);
        if (data.usuario_id() == null) {
            return null;
        } else {
            return usuarioRepositorio.save(usuario);
        }
    }

    //BUSCAR USUARIO POR CPF
    @GetMapping("/buscarPorCpf")
    public List<Usuarios> buscarUsuarioPorCPF(@RequestParam String usuario_cpf) {
        return usuarioRepositorio.buscarUsuarioPorCPF(usuario_cpf);
    }

    //BUSCAR USUARIO POR EMAIL
    @GetMapping("/buscarPorEmail")
    public List<Usuarios> buscarUsuarioPorEmail(@RequestParam String usuario_email) {
        return usuarioRepositorio.buscarUsuarioPorEmail(usuario_email);
    }
}
