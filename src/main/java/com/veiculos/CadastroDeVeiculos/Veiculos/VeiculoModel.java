package com.veiculos.CadastroDeVeiculos.Veiculos;

import com.veiculos.CadastroDeVeiculos.Pessoas.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_veiculos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VeiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private int ano;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaModel pessoa;

}
