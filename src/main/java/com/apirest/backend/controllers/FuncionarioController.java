package com.apirest.backend.controllers;

import java.util.List;

import com.apirest.backend.errors.BadRequest;
import com.apirest.backend.errors.NotFound;
import com.apirest.backend.models.Funcionario;
import com.apirest.backend.repo.FuncionarioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(value="/api")
public class FuncionarioController {

    @Autowired
    FuncionarioRepo funcionarioRepo;

    @GetMapping("/funcionarios")
    public List<Funcionario> listaFuncionarios() {
        return funcionarioRepo.findAll();
    }

    @GetMapping("/funcionario/{id}")
    public Funcionario listaPorId(@PathVariable(value="id") long id) {
        Funcionario funcionario = funcionarioRepo.findById(id);
        if (funcionario == null) {
            throw new NotFound();
        }
        return funcionario;
    }

    @PostMapping("/funcionario")
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvaFuncionario(@RequestBody Funcionario funcionario) {
        String[] dados = {
            funcionario.getNome(),
            funcionario.getCargo(),
            funcionario.getImgURL(),
        };
        for (String elemento: dados) {
            if (elemento == null) {
                throw new BadRequest();
            }
        }

        Number[] dados2 = {
            funcionario.getIdade(),
            funcionario.getSalario()
        };
        for (Number elemento: dados2) {
            if (elemento == null) {
                throw new BadRequest();
            }
        }
        return funcionarioRepo.save(funcionario);
    }

    @DeleteMapping("/funcionario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaFuncionario(@PathVariable(value="id") long id) {
        Funcionario funcionario = funcionarioRepo.getById(id);
        funcionarioRepo.delete(funcionario);
    }

    @PutMapping("/funcionario/{id}")
    public Funcionario atualizaFuncionario(@PathVariable(value="id") long id, @RequestBody Funcionario funcionario) {
        funcionario.setId(id);
            
        String[] dados = {
            funcionario.getNome(),
            funcionario.getCargo(),
            funcionario.getImgURL(),
        };
        for (String elemento: dados) {
            if (elemento == null) {
                throw new BadRequest();
            }
        }

        Number[] dados2 = {
            funcionario.getIdade(),
            funcionario.getSalario()
        };
        for (Number elemento: dados2) {
            if (elemento == null) {
                throw new BadRequest();
            }
        }
        return funcionarioRepo.save(funcionario);
    }
}
