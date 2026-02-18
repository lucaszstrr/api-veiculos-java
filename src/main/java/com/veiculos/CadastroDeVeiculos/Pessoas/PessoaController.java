package com.veiculos.CadastroDeVeiculos.Pessoas;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PessoaController {

    @PostMapping("/pessoa")
    public void criarPessoa() {

    }

    @GetMapping("/pessoa/{id}")
    public String mostrarPessoa() {
        return "Pessoa por id";
    }

    @GetMapping("/pessoas")
    public String mostrarTodos() {
        return "Todas as pessoas";
    }

    @PutMapping("/pessoa/{id}")
    public void atualizarDados() {

    }

    @DeleteMapping("/pessoa/{id}")
    public void deletarPessoa() {

    }
}
