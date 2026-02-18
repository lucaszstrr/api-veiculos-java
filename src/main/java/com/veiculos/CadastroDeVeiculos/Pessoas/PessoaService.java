package com.veiculos.CadastroDeVeiculos.Pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Listar pessoas
    public List<PessoaModel> listarPessoas() {
        return pessoaRepository.findAll();
    }

}
