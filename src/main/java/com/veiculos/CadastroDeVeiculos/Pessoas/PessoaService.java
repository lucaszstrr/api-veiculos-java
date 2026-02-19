package com.veiculos.CadastroDeVeiculos.Pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaMapper pessoaMapper;

    // Cadastrar pessoa
    public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDTO) {
        PessoaModel pessoa = pessoaMapper.map(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.map(pessoa);
    }

    // Listar pessoas
    public List<PessoaModel> listarPessoas() {
        return pessoaRepository.findAll();
    }

    // Listar pessoa por ID
    public PessoaModel listarPessoaPorId(Long id) {
        Optional<PessoaModel> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    // Atualizar pessoa
    public PessoaModel atualizarPessoa(Long id, PessoaModel pessoa) {
        if (pessoaRepository.existsById(id)) {
            pessoa.setId(id);
            return pessoaRepository.save(pessoa);
        }

        return null;
    }

    // Deletar pessoa
    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

}
