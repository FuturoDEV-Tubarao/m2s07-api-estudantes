package com.senai.estudante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.estudante.model.Estudante;
import com.senai.estudante.repository.EstudanteRepository;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;
    

    public List<Estudante> consultar() {
        var estudantes = repository.consultar();
        return estudantes;
    }

    public void inserir(Estudante estudante) {
        boolean existente = repository.existe(estudante.getMatricula());
        if (existente)
            throw new IllegalArgumentException("Matricula já cadastrada!"); 
        repository.inserir(estudante);
    }

}
