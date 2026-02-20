package com.veiculos.CadastroDeVeiculos.Veiculos;

import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public VeiculoModel map(VeiculoDTO veiculoDTO) {
        VeiculoModel veiculoModel = new VeiculoModel();

        veiculoModel.setId(veiculoDTO.getId());
        veiculoModel.setMarca(veiculoDTO.getMarca());
        veiculoModel.setModelo(veiculoDTO.getModelo());
        veiculoModel.setAno(veiculoDTO.getAno());
        veiculoModel.setPessoa(veiculoDTO.getPessoa());

        return veiculoModel;
    }

    public VeiculoDTO map(VeiculoModel veiculoModel) {
        VeiculoDTO veiculoDTO = new VeiculoDTO();

        veiculoDTO.setId(veiculoModel.getId());
        veiculoDTO.setMarca(veiculoModel.getMarca());
        veiculoDTO.setModelo(veiculoModel.getModelo());
        veiculoDTO.setAno(veiculoModel.getAno());
        veiculoDTO.setPessoa(veiculoModel.getPessoa());

        return veiculoDTO;
    }

}
