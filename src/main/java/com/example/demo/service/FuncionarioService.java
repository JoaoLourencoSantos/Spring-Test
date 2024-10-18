package com.example.demo.service;

import com.example.demo.repository.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    public Funcionario save(Funcionario funcionario, Double zazaza) {
        funcionario.setSalario(funcionario.getSalario()*zazaza);
        return repository.save(funcionario);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
