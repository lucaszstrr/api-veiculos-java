package com.veiculos.CadastroDeVeiculos.Pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Listar pessoas
    public List<PessoaModel> listarPessoas() {
        return pessoaRepository.findAll();
    }

    // Listar pessoa por ID
    public PessoaModel listarPessoaPorId(Long id) {
        Optional<PessoaModel> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    // Cadastrar pessoa
    public PessoaModel cadastrarPessoa(PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
