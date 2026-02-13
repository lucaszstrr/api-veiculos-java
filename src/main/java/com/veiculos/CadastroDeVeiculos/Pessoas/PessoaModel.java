package com.veiculos.CadastroDeVeiculos.Pessoas;

import com.veiculos.CadastroDeVeiculos.Veiculos.VeiculoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_pessoas")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "pessoaId")
    private List<VeiculoModel> veiculoId;

    public PessoaModel() {
    }

    public PessoaModel(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
