package com.co.ao.universidade.universidade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.co.ao.universidade.universidade.models.curso.Curso;
import com.co.ao.universidade.universidade.repository.curso.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Iterable<Curso> pesquisarCursos() {
        return cursoRepository.findAll();
    }

    public @ResponseBody Curso salvar(Curso curso){
        return cursoRepository.save(curso);
    }

}
