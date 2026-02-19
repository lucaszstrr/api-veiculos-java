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
    public PessoaDTO criarPessoa(@RequestBody PessoaDTO pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping("/pessoa/{id}")
    public PessoaDTO mostrarPessoa(@PathVariable Long id) {
        return pessoaService.listarPessoaPorId(id);
    }

    @GetMapping("/pessoas")
    public List<PessoaDTO> mostrarTodos() {
        return pessoaService.listarPessoas();
    }

    @PutMapping("/pessoa/{id}")
    public PessoaDTO atualizarDados(@PathVariable Long id, @RequestBody PessoaDTO pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/pessoa/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
    }
}
