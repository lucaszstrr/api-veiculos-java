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

    @GetMapping("/listar/{id}")
    public ResponseEntity<List<VeiculoDTO>> mostrarVeiculo(@PathVariable Long id) {
        List<VeiculoDTO> veiculosUsuario = veiculoService.listarVeiculoPorId(id);

        if (veiculosUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(veiculosUsuario);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VeiculoDTO>> mostrarTodosVeiculos() {
        List<VeiculoDTO> veiculos = veiculoService.listarVeiculos();

        return ResponseEntity.ok(veiculos);
    }

    @PutMapping("/atualizar/{pessoa_id}/{veiculo_id}")
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable Long pessoa_id, @PathVariable Long veiculo_id, @RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO veiculoAtualizado = veiculoService.atualizarVeiculo(pessoa_id, veiculo_id, veiculoDTO);

        if (veiculoAtualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(veiculoAtualizado);
    }

    @DeleteMapping("/deletar/{pessoa_id}/{veiculo_id}")
    public ResponseEntity<VeiculoDTO> deletarVeiculo(@PathVariable Long pessoa_id, @PathVariable Long veiculo_id) {
        VeiculoDTO veiculoDeletado = veiculoService.deletarVeiculo(pessoa_id, veiculo_id);

        if (veiculoDeletado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(veiculoDeletado);
    }
}
