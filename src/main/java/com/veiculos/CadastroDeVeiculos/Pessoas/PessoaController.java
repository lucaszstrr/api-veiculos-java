package com.veiculos.CadastroDeVeiculos.Pessoas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/pessoa")
    public PessoaModel criarPessoa(@RequestBody PessoaModel pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping("/pessoa/{id}")
    public PessoaModel mostrarPessoa(@PathVariable Long id) {
        return pessoaService.listarPessoaPorId(id);
    }

    @GetMapping("/pessoas")
    public List<PessoaModel> mostrarTodos() {
        return pessoaService.listarPessoas();
    }

    @PutMapping("/pessoa/{id}")
    public void atualizarDados() {

    }

    @DeleteMapping("/pessoa/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
    }
}
