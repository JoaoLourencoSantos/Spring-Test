package com.example.demo.service;

import com.example.demo.repository.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.FuncionarioRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioRepositoryImpl repositoryImpl;

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    /**
     * Tratar e normalizar a busca do cpf
     * */
    public Funcionario findByCpf(String cpf) {
        return repositoryImpl.findByCPF(cpf);
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
