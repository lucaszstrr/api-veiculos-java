package com.veiculos.CadastroDeVeiculos.Pessoas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/pessoa")
    public ResponseEntity<String> criarPessoa(@RequestBody PessoaDTO pessoa) {
        pessoaService.cadastrarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pessoa cadastrada com sucesso");
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
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id) {
        if (pessoaService.listarPessoaPorId(id) != null) {
            pessoaService.deletarPessoa(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Pessoa deletada com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("Pessoa não encontrada");
    }
}
