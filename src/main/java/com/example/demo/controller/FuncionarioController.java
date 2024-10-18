package com.example.demo.controller;

import com.example.demo.repository.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fun")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario, Double xaxaxa) {
        return service.save(funcionario, xaxaxa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(
            @PathVariable Long id, @RequestBody Funcionario funcionario) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(id);
        return ResponseEntity.ok(service.save(funcionario, null));
    }

    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElse(null);

        if (funcionario == null) {
            return;
        }

        repository.delete(funcionario);
        return;
    }

}
