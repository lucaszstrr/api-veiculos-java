package com.veiculos.CadastroDeVeiculos.Pessoas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.veiculos.CadastroDeVeiculos.Veiculos.VeiculoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_pessoas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "pessoaId")
    @JsonIgnore
    private List<VeiculoModel> veiculoId;

}
