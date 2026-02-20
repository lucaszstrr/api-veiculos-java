package com.veiculos.CadastroDeVeiculos.Veiculos;

import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public VeiculoModel map(VeiculoDTO veiculoDTO) {
        VeiculoModel veiculoModel = new VeiculoModel();

        veiculoModel.setMarca(veiculoDTO.getMarca());
        veiculoModel.setModelo(veiculoDTO.getModelo());
        veiculoModel.setAno(veiculoDTO.getAno());
        veiculoModel.setPessoaId(veiculoDTO.getPessoaId());

        return veiculoModel;
    }

    public VeiculoDTO map(VeiculoModel veiculoModel) {
        VeiculoDTO veiculoDTO = new VeiculoDTO();

        veiculoDTO.setMarca(veiculoModel.getMarca());
        veiculoDTO.setModelo(veiculoModel.getModelo());
        veiculoDTO.setAno(veiculoModel.getAno());
        veiculoDTO.setPessoaId(veiculoModel.getPessoaId());

        return veiculoDTO;
    }

}
