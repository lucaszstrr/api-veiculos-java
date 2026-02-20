package com.veiculos.CadastroDeVeiculos.Veiculos;

import com.veiculos.CadastroDeVeiculos.Pessoas.PessoaModel;
import com.veiculos.CadastroDeVeiculos.Pessoas.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private VeiculoMapper veiculoMapper;
    @Autowired
    private PessoaRepository pessoaRepository;

    // Criar um novo veiculo
    public VeiculoDTO cadastrarVeiculo(Long id, VeiculoDTO veiculoDTO) {

        if (!pessoaRepository.existsById(id)) {
            return null;
        }

        PessoaModel proprietario = pessoaRepository.findById(id).orElse(null);

        VeiculoModel veiculoModel = veiculoMapper.map(veiculoDTO);

        veiculoModel.setPessoa(proprietario);

        veiculoRepository.save(veiculoModel);

        return veiculoMapper.map(veiculoModel);

    }

    // Lista todos os veiculos
    public List<VeiculoDTO> listarVeiculos() {
        List<VeiculoModel> veiculos = veiculoRepository.findAll();

        return veiculos.stream()
                .map(veiculoMapper::map)
                .collect(Collectors.toList());
    }

    // Lista todos os veiculos de um usuario por id
    public List<VeiculoDTO> listarVeiculoPorId(Long id) {
        List<VeiculoModel> veiculos = veiculoRepository.findAll();

        PessoaModel proprietario = pessoaRepository.findById(id).orElse(null);

        if (proprietario == null) {
            return null;
        }

        return veiculos.stream()
                .filter(veiculo -> veiculo.getPessoa() == proprietario)
                .map(veiculoMapper::map)
                .collect(Collectors.toList());
    }

}
