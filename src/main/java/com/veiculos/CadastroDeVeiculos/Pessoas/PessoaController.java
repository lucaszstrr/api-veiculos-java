package com.veiculos.CadastroDeVeiculos.Pessoas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarPessoa(@RequestBody PessoaDTO pessoa) {
        pessoaService.cadastrarPessoa(pessoa);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pessoa cadastrada com sucesso");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PessoaDTO> mostrarPessoa(@PathVariable Long id) {
        PessoaDTO pessoa = pessoaService.listarPessoaPorId(id);

        if (pessoa == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaDTO>> mostrarTodos() {
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();

        if (pessoas == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(pessoas);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PessoaDTO> atualizarDados(@PathVariable Long id, @RequestBody PessoaDTO pessoa) {
        PessoaDTO pessoaAtualizar =  pessoaService.atualizarPessoa(id, pessoa);

        if (pessoaAtualizar == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(pessoaAtualizar);
    }

    @DeleteMapping("/deletar/{id}")
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
