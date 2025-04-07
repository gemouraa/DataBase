package com.aula.atividade.controller;


import com.aula.atividade.model.Funcionario;
import com.aula.atividade.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/funcionario")
@RestController
@CrossOrigin(origins = "*")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String, String>> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity.ok()
                .body(Map.of("message", "Funcionario salvo com sucesso"));
    }
    @PutMapping
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok()
                .body(Map.of("message", "Funcionario atualizado com sucesso"));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity.ok()
                .body(Map.of("message", "Funcionario excluído com sucesso"));
    }
}
