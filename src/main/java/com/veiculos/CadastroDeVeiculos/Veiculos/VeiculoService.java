package com.veiculos.CadastroDeVeiculos.Veiculos;

import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }



}
