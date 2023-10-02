package com.abrigos.ControllerS;

import com.abrigos.Classes.Abrigos;
import com.abrigos.DTOs.AbrigoRequestDTO;
import com.abrigos.DTOs.AbrigoResponseDTO;
import com.abrigos.Repositorios.AbrigoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("abrigos")

public class AbrigoController {
    @Autowired
    private AbrigoRepositorio abrigoRepositorio;

    //INSERIR ABRIGOS
    @PostMapping
    public Abrigos inserirAbrigo(@RequestBody AbrigoRequestDTO data) {
        Abrigos abrigosData = new Abrigos(data);
        return abrigoRepositorio.save(abrigosData);
    }

    //BUSCAR TODOS ABRIGOS CADASTRADOS
    @GetMapping("/todos")
    public List<AbrigoResponseDTO> getAList() {
        List<AbrigoResponseDTO> responseDTOS = abrigoRepositorio.findAll().stream().map(AbrigoResponseDTO::new).toList();
        return responseDTOS;
    }

    //BUSCAR ABRIGO POR ID
    @GetMapping("/{abrigo_id}")
    public Abrigos buscarAbrigo(@PathVariable("abrigo_id")Long id) {
        Abrigos abrigos = abrigoRepositorio.findById(id).orElse(null);
        return abrigos;
    }

    //DELETAR ABRIGO POR ID
    @DeleteMapping("/{abrigo_id}")
    public Abrigos excluirAbrigo(@PathVariable("abrigo_id")Long id) {
        Abrigos abrigos = abrigoRepositorio.findById(id).orElse(null);
        if (abrigos != null) {
            abrigoRepositorio.deleteById(id);
        }
        return abrigos;
        }

    //ALTERAR ABRIGO
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping("/{abrigo_id}")
    public Abrigos alterarAbrigo(@RequestBody AbrigoRequestDTO data) {
        Abrigos abrigos = new Abrigos(data);
        if (data.abrigo_id() == null) {
            return null;
        } else {
            return abrigoRepositorio.save(abrigos);
        }
    }

    //BUSCAR ABRIGOS ATIVOD
    @GetMapping("/ativos")
    public List<Abrigos>ObterStatusAtivo(){
        return abrigoRepositorio.obterAbrigosAtivos();
    }

    //BUSCAR ABRIGOS INATIVOS
    @GetMapping("/inativos")
    public List<Abrigos>ObterStatusInativo(){
        return abrigoRepositorio.obterAbrigosInativos();
    }

    //BUSCAR ABRIGOS POR NOME EM ORDEM CRESCENTE
    @GetMapping("/nomeCrescente")
    public List<Abrigos> ordemCrescente() {
       return abrigoRepositorio.ordemNomeCrescente();
    }

    //BUSCAR ABRIGOS POR NOME EM ORDEM DECRESCENTE
    @GetMapping("/nomeDecrescente")
    public List<Abrigos> ordemDecrescente() {
        return abrigoRepositorio.ordemNomeDecrescente();
    }

    //BUSCAR ABRIGOS POR CAPACIDADE EM ORDEM CRESCENTE
    @GetMapping("/capacidadeCrescente")
    public List<Abrigos> capacidadeCrescente() {
        return abrigoRepositorio.ordemCapacidadeCrescente();
    }

    //BUSCAR ABRIGOS POR CAPACIDADE EM ORDEM CCRESCENTE
    @GetMapping("/capacidadeDecrescente")
    public List<Abrigos> capacidadeDecrescente() {
        return abrigoRepositorio.ordemCapacidadeDecrescente();
    }

    //BUSCAR ABRIGOS POR ESTADO
    @GetMapping("/buscarPorEstado")
    public List<Abrigos> buscarAbrigoPorEstado(@RequestParam String abrigo_estado) {
        return abrigoRepositorio.buscarAbrigoPorEstado(abrigo_estado);
    }

    //BUSCAR ABRIGOS POR RESPONSAVEL
    @GetMapping("/buscarPorResponsavel")
    public List<Abrigos> buscarAbrigoPorResponsavel(@RequestParam String abrigo_responsavel) {
        return abrigoRepositorio.buscarAbrigoPorResponsavel(abrigo_responsavel);
    }

    //BUSCAR ABRIGOS POR NOME
    @GetMapping("/buscarPorNome")
    public List<Abrigos> buscarAbrigoPorNome(@RequestParam String abrigo_nome) {
        return abrigoRepositorio.buscarAbrigoPorNome(abrigo_nome);
    }

    //BUSCAR ABRIGOS POR CIDADE
    @GetMapping("/buscarPorCidade")
    public List<Abrigos> buscarAbrigoPorCidade(@RequestParam String abrigo_cidade) {
        return abrigoRepositorio.buscarAbrigoPorCidade(abrigo_cidade);
    }
}