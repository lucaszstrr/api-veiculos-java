package com.veiculos.CadastroDeVeiculos.Veiculos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class VeiculoController {

    @PostMapping("/veiculo")
    public void criarVeiculo() {

    }

    @GetMapping("/veiculo/{id}")
    public void mostrarVeiculo() {

    }

    @GetMapping("/veiculos")
    public void mostrarTodosVeiculos() {

    }

    @PutMapping("/veiculo/{id}")
    public void atualizarVeiculo() {

    }

    @DeleteMapping("/veiculo/{id}")
    public void deletarVeiculo() {

    }
}
