package com.veiculos.CadastroDeVeiculos.Veiculos;

import com.veiculos.CadastroDeVeiculos.Pessoas.PessoaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculos")
public class VeiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int ano;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaModel pessoaId;

    public VeiculoModel() {
    }

    public VeiculoModel(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
