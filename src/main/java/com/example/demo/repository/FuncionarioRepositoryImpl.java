package com.example.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class FuncionarioRepositoryImpl {

    @Autowired
    protected EntityManager entityManager;

    /**
     * A busca deve retornar somente um usuário com o CPF informado.
     * A busca não deve retornar usuários excluídos.
     * A busca deve retonar apenas funcionarios com o valor setor e salário não nulo
     * A busca deve retornar funcionarios com o cpf formatado e desformatado
     * */
    public Funcionario findByCPF(String cpf) {
        StringBuilder sql = new StringBuilder()
                .append(" SELECT funcionario ")
                .append(" FROM Funcionario funcionario ")
                .append(" WHERE cpf = :cpf ");

        Query query = entityManager.createNativeQuery(sql.toString(), Funcionario.class)
                .setParameter("cpf", cpf);

        return (Funcionario) query.getSingleResult();
    }
}
