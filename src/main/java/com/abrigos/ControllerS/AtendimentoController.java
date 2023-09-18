package com.abrigos.ControllerS;

import com.abrigos.Classes.Atendimentos;
import com.abrigos.DTOs.*;
import com.abrigos.Repositorios.AtendimentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atendimentos")

public class AtendimentoController {
    @Autowired
    private AtendimentoRepositorio atendimentoRepositorio;

    //INSERIR ATENDIMENTO
    @PostMapping
    public Atendimentos inserirAtendimento(@RequestBody AtendimentoRequstDTO data) {
        Atendimentos atendimentoData = new Atendimentos(data);
        return atendimentoRepositorio.save(atendimentoData);
    }

    //BUSCAR TODOS ATENDIEMNTOS CADASTRADOS
    @GetMapping("/todos")
    public List<AtendimentoResponseDTO> getAList() {
        List<AtendimentoResponseDTO> responseDTOS = atendimentoRepositorio.findAll().stream().map(AtendimentoResponseDTO::new).toList();
        return responseDTOS;
    }

    //BUSCAR ATENDIMENTO POR ID
    @GetMapping("/{atendimento_id}")
    public Atendimentos buscarAtendimento(@PathVariable("atendimento_id") Long id) {
        Atendimentos atendimentos = atendimentoRepositorio.findById(id).orElse(null);
        return atendimentos;
    }

    //DELETAR ATENDIMENTO POR ID
    @DeleteMapping("/{atendimento_id}")
    public Atendimentos excluirAtendiemnto(@PathVariable("atendimento_id") Long id) {
        Atendimentos atendimentos = atendimentoRepositorio.findById(id).orElse(null);
        if (atendimentos != null) {
            atendimentoRepositorio.deleteById(id);
        }
        return atendimentos;
    }

    //ALTERAR ATENDIMENTO
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping
    public Atendimentos alterarAtendimento(@RequestBody AtendimentoRequstDTO data) {
        Atendimentos atendimentos = new Atendimentos(data);
        if (data.atendimento_id() == null) {
            return null;
        } else {
            return atendimentoRepositorio.save(atendimentos);
        }
    }

    //BUSCAR ATENDIMENTO POR RESPONSAVEL
    @GetMapping("/buscarPorResponsavel")
    public List<Atendimentos> buscarAtendimentoPorResponsavel(@RequestParam String atendimento_responsavel) {
        return atendimentoRepositorio.buscarAtendimentoPorResponsavel(atendimento_responsavel);
    }

    //BUSCAR ATENDIMENTO POR ABRIGO
    @GetMapping("/buscarPorAbrigo")
    public List<Atendimentos> buscarAtendimentoPorAbrigo(@RequestParam Long abrigo_id) {
        return atendimentoRepositorio.buscarAtendimentoPorAbrigo(abrigo_id);
    }

    //BUSCAR ATENDIMENTO POR ABRIGO
    @GetMapping("/buscarPorPessoa")
    public List<Atendimentos> buscarAtendimentoPorPessoa(@RequestParam Long pessoa_id) {
        return atendimentoRepositorio.buscarAtendimentoPorPessoa(pessoa_id);
    }
}
