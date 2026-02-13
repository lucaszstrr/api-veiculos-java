package com.veiculos.CadastroDeVeiculos.Pessoas;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoas")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

}
