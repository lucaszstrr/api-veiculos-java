package com.veiculos.CadastroDeVeiculos.Pessoas;

import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaModel map(PessoaDTO pessoaDTO) {
        PessoaModel pessoaModel = new PessoaModel();

        pessoaModel.setId(pessoaDTO.getId());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setEmail(pessoaDTO.getEmail());

        return pessoaModel;
    }

    public PessoaDTO map(PessoaModel pessoaModel) {
        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setEmail(pessoaModel.getEmail());

        return pessoaDTO;
    }

}
