package com.apirest.backend.controllers;

import java.util.List;

import com.apirest.backend.models.Funcionario;
import com.apirest.backend.repo.FuncionarioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class FuncionarioController {

    @Autowired
    FuncionarioRepo funcionarioRepo;

    @GetMapping("/funcionarios")
    public List<Funcionario> listaFuncionarios() {
        return funcionarioRepo.findAll();
    }

    
}
