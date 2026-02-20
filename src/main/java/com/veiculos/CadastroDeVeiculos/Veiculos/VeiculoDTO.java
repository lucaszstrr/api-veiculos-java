package com.veiculos.CadastroDeVeiculos.Veiculos;

import com.veiculos.CadastroDeVeiculos.Pessoas.PessoaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VeiculoDTO {

    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private PessoaModel pessoa;

}
