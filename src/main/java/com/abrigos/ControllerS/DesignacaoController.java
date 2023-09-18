package com.abrigos.ControllerS;

import com.abrigos.Classes.Designacao;
import com.abrigos.DTOs.*;
import com.abrigos.Repositorios.DesignacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("designacao")

public class DesignacaoController {
    @Autowired
    private DesignacaoRepositorio designacaoRepositorio;

    //INSERIR DESIGNAÇÃO
    @PostMapping
    public Designacao inserirDesignacao(@RequestBody DesignacaoRequestDTO data) {
        Designacao designacaoData = new Designacao(data);
        return designacaoRepositorio.save(designacaoData);
        }

    //BUSCAR TODAS DESIGNAÇÕES CADASTRADAS
    @GetMapping("/todos")
    public List<DesignacaoResponseDTO> getAList() {
        List<DesignacaoResponseDTO> responseDTOS = designacaoRepositorio.findAll().stream().map(DesignacaoResponseDTO::new).toList();
        return responseDTOS;
    }

    //BUSCAR DESIGNAÇÂO POR ID
    @GetMapping("/{designacao_id}")
    public Designacao buscarDesignacao(@PathVariable("designacao_id")Long id) {
        Designacao designacao = designacaoRepositorio.findById(id).orElse(null);
        return designacao;
    }

    //DELETAR DESIGNAÇÃO POR ID
    @DeleteMapping("/{designacao_id}")
    public Designacao excluirDesignacao(@PathVariable("designacao_id")Long id) {
        Designacao designacao = designacaoRepositorio.findById(id).orElse(null);
        if (designacao != null) {
            designacaoRepositorio.deleteById(id);
        }
        return designacao;
    }

    //ALTERAR DESIGNAÇÃO
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping
    public Designacao alterarDesignacao(@RequestBody DesignacaoRequestDTO data) {
        Designacao designacao = new Designacao(data);
        if (data.designacao_id() == null) {
            return null;
        } else {
            return designacaoRepositorio.save(designacao);
        }
    }

    //BUSCAR ATENDIMENTO POR ID ABRIGO
    @GetMapping("/buscarPorAbrigo")
    public List<Designacao> buscarDesignacaoPorAbrigo(@RequestParam Long abrigo_id) {
        return designacaoRepositorio.buscarDesignacaoPorAbrigo(abrigo_id);
    }

    //BUSCAR ATENDIMENTO POR ID ABRIGO
    @GetMapping("/buscarPorPessoa")
    public List<Designacao> buscarDesignacaoPorPessoa(@RequestParam Long pessoa_id) {
        return designacaoRepositorio.buscarDesignacaoPorPessoa(pessoa_id);
    }

    //BUSCAR ATENDIMENTO POR ID ABRIGO
    @GetMapping("/buscarPorResponsavel")
    public List<Designacao> buscarDesignacaoPorResponsavel(@RequestParam String designacao_responsavel) {
        return designacaoRepositorio.buscarDesignacaoPorResponsavel(designacao_responsavel);
    }

}
