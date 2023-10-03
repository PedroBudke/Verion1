package com.abrigos.ControllerS;

import com.abrigos.Classes.Pessoas;
import com.abrigos.DTOs.PessoaRequestDTO;
import com.abrigos.DTOs.PessoaResponseDTO;
import com.abrigos.Repositorios.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")

public class PessoaController {
    @Autowired
    private PessoaRepositorio pesssoaRepositorio;

    //INSERIR PESSOA
    @PostMapping
    public Pessoas inserirPessoa(@RequestBody PessoaRequestDTO data){
        Pessoas pessoaData = new Pessoas(data);
        return pesssoaRepositorio.save(pessoaData);
    }

    //BUSCAR TODAS AS PESSOAS CADASTRADAS
    @GetMapping("/BuscarTodasPessoas")
    public List<PessoaResponseDTO> getAList(){
        List<PessoaResponseDTO> responseDTOS = pesssoaRepositorio.findAll().stream().map(PessoaResponseDTO::new).toList();
        return responseDTOS;
    }

    //BUSCAR PESSOA POR ID
    @GetMapping("/{pessoa_id}")
    public Pessoas buscarPessoa(@PathVariable("pessoa_id")Long id) {
        Pessoas pessoas = pesssoaRepositorio.findById(id).orElse(null);
        return pessoas;
    }

    //DELETAR PESSOA POR ID
    @DeleteMapping("/{pessoa_id}")
    public Pessoas excluirPessoa(@PathVariable("pessoa_id")Long id) {
        Pessoas pessoas = pesssoaRepositorio.findById(id).orElse(null);
        if (pessoas != null) {
            pesssoaRepositorio.deleteById(id);
        }
        return pessoas;
    }

    //ALTERAR PESSOA
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping("/{pessoa_id}")
    public Pessoas alterarPessoa(@RequestBody PessoaRequestDTO data) {
        Pessoas pessoas = new Pessoas(data);
        if (data.pessoa_id() == null) {
            return null;
        } else {
            return pesssoaRepositorio.save(pessoas);
        }
    }

    //BUSCAR PESSOAS POR NOME EM ORDEM CRESCENTE
    @GetMapping("/nomeCrescente")
    public List<Pessoas> ordemCrescente() {
        return pesssoaRepositorio.ordemNomeCrescente();
    }

    //BUSCAR PESSOAS POR NOME EM ORDEM DECRESCENTE
    @GetMapping("/nomeDecrescente")
    public List<Pessoas> ordemDerescente() {
        return pesssoaRepositorio.ordemNomeDecrescente();
    }

    //BUSCAR PESSOAS POR CPF
    @GetMapping("/buscarPorCpf")
    public List<Pessoas> buscarPessoaPorCpf(@RequestParam String pessoa_cpf) {
        return pesssoaRepositorio.buscarPessoaPorCPF(pessoa_cpf);
    }

    //BUSCAR ABRIGOS POR NOME
    @GetMapping("/buscarPorNome")
    public List<Pessoas> buscarPessoaPorNome(@RequestParam String pessoa_nome) {
        return pesssoaRepositorio.buscarPessoaPorNome(pessoa_nome);
    }
    //BUSCAR ABRIGOS POR NOME
    @GetMapping("/buscarPorContato")
    public List<Pessoas> buscarPessoaPorContato(@RequestParam String pessoa_contato) {
        return pesssoaRepositorio.buscarPessoaPorContato(pessoa_contato);
    }

    //BUSCAR ABRIGOS POR EMAIL
    @GetMapping("/buscarPorEmail")
    public List<Pessoas> buscarPessoaPorEmail(@RequestParam String pessoa_email) {
        return pesssoaRepositorio.buscarPessoaPorEmail(pessoa_email);
    }

    //BUSCAR ABRIGOS POR EMAIL
    @GetMapping("/buscarPorGenero")
    public List<Pessoas> buscarPessoaPorGenero(@RequestParam String pessoa_genero) {
        return pesssoaRepositorio.buscarPessoaPorGenero(pessoa_genero);
    }

    //BUSCAR ABRIGOS POR CEP
    @GetMapping("/buscarPorCep")
    public List<Pessoas> buscarPessoaPorCep(@RequestParam String pessoa_cep) {
        return pesssoaRepositorio.buscarPessoaPorCep(pessoa_cep);
    }

    //BUSCAR ABRIGOS POR RUA
    @GetMapping("/buscarPorRua")
    public List<Pessoas> buscarPessoaPorRua(@RequestParam String pessoa_rua) {
        return pesssoaRepositorio.buscarPessoaPorRua(pessoa_rua);
    }

    //BUSCAR ABRIGOS POR BAIRRO
    @GetMapping("/buscarPorBairro")
    public List<Pessoas> buscarPessoaPorBairro(@RequestParam String pessoa_bairro) {
        return pesssoaRepositorio.buscarPessoaPorBairro(pessoa_bairro);
    }

    //BUSCAR ABRIGOS POR CIDADE
    @GetMapping("/buscarPorCidade")
    public List<Pessoas> buscarPessoaPorCidade(@RequestParam String pessoa_cidade) {
        return pesssoaRepositorio.buscarPessoaPorCidade(pessoa_cidade);
    }

    //BUSCAR ABRIGOS POR ESTADO
    @GetMapping("/buscarPorEstado")
    public List<Pessoas> buscarPessoaPorEstado(@RequestParam String pessoa_estado) {
        return pesssoaRepositorio.buscarPessoaPorEstado(pessoa_estado);
    }

    //BUSCAR ABRIGOS POR USUARIO
    @GetMapping("/buscarPorUsuario")
    public List<Pessoas> buscarPessoaPorUsuario(@RequestParam String pessoa_usuario) {
        return pesssoaRepositorio.buscarPessoaPorUsuario(pessoa_usuario);
    }

}
