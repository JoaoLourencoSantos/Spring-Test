package com.example.demo.repository;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "cpf", unique = true)
    private String cpf;

    private String setor;
    private Double salario;
    private UUID identifier;

    private boolean excluido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID key) {
        this.identifier = key;
    }
}
