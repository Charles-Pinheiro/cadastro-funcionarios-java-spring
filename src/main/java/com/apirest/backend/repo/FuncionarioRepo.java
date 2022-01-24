package com.apirest.backend.repo;

import com.apirest.backend.models.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Long> {
    
}
