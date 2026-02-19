package com.veiculos.CadastroDeVeiculos.Pessoas;

import com.veiculos.CadastroDeVeiculos.Veiculos.VeiculoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {

    private Long id;
    private String nome;
    private String email;
    private List<VeiculoModel> veiculoId;

}
