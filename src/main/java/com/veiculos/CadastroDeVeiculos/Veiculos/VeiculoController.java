package com.veiculos.CadastroDeVeiculos.Veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/criar/{id}")
    public ResponseEntity<VeiculoDTO> criarVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO veiculoSalvo = veiculoService.cadastrarVeiculo(id, veiculoDTO);

        if(veiculoSalvo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
    }

    @GetMapping("/veiculo/{id}")
    public void mostrarVeiculo() {

    }

    @GetMapping("/veiculos")
    public ResponseEntity<List<VeiculoDTO>> mostrarTodosVeiculos() {
        List<VeiculoDTO> veiculos = veiculoService.listarVeiculos();

        return ResponseEntity.ok(veiculos);
    }

    @PutMapping("/veiculo/{id}")
    public void atualizarVeiculo() {

    }

    @DeleteMapping("/veiculo/{id}")
    public void deletarVeiculo() {

    }
}
