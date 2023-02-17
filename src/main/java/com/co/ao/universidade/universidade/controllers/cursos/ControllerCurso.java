package com.co.ao.universidade.universidade.controllers.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.ao.universidade.universidade.models.curso.Curso;
import com.co.ao.universidade.universidade.services.CursoService;

@RestController
@RequestMapping("curso")
public class ControllerCurso {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public Iterable<Curso> pesquisarCurso() {
        return cursoService.pesquisarCursos();
    }

    @PostMapping
    public @ResponseBody Curso salvar(Curso estudante) {
        return cursoService.salvar(estudante);
    }
    
}
