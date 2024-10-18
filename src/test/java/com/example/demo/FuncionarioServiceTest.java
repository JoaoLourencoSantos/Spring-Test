package com.example.demo;

import com.example.demo.repository.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.service.FuncionarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class FuncionarioServiceTest {

    @InjectMocks
    private FuncionarioService funcionarioService;

    @Mock
    private FuncionarioRepository repository;

    @Test
    void contextLoads() {
        doReturn(mockFuncionario()).when(repository).findAll();
    }

    @Test
    void testMock() {
        assertNotNull(mockFuncionario());
    }

    private Funcionario mockFuncionario() {
        return null;
    }

}
