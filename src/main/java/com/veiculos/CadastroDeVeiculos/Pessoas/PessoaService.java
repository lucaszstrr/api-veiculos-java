package com.veiculos.CadastroDeVeiculos.Pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<PessoaDTO> listarPessoas() {
        List<PessoaModel> pessoas = pessoaRepository.findAll();
        return pessoas.stream()
                .map(pessoaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar pessoa por ID
    public PessoaDTO listarPessoaPorId(Long id) {
        Optional<PessoaModel> pessoa = pessoaRepository.findById(id);

        return pessoa.map(pessoaMapper::map).orElse(null);
    }

    // Atualizar pessoa
    public PessoaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO) {
        Optional<PessoaModel> pessoaExistente = pessoaRepository.findById(id);

        if (pessoaExistente.isPresent()) {
            PessoaModel pessoa = pessoaMapper.map(pessoaDTO);
            pessoa.setId(id);
            pessoaRepository.save(pessoa);
            return pessoaMapper.map(pessoa);
        }

        return null;
    }

    // Deletar pessoa
    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

}
