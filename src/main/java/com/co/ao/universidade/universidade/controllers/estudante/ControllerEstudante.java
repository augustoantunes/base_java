package com.co.ao.universidade.universidade.controllers.estudante;

import java.util.List;
import java.util.Optional;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.co.ao.universidade.universidade.DTO.estudante.EstudanteCursoProjection;
import com.co.ao.universidade.universidade.DTO.response.ResponseDefault;
import com.co.ao.universidade.universidade.models.estudante.Estudante;
import com.co.ao.universidade.universidade.services.EstudanteService;

@RestController
@RequestMapping("estudante")
public class ControllerEstudante {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseDefault<List<Estudante>> pesquisarEstudante() {
        return new ResponseDefault<>(estudanteService.obterTodosEstudantes());
    }

    @GetMapping( path = "/{id}")
    public ResponseDefault<Optional<Estudante>> detalheEstudante(@PathVariable int id){
        return new ResponseDefault<>(estudanteService.obterEstudante(id));
    }

    // @GetMapping(value = "/curso")
    // public Iterable<EstudanteCurso> pesquisarEstudantesAll() {
    //     List<Estudante> estudantes = estudanteRepository.findAll();
    //     return estudantes.stream().map(e -> new EstudanteCurso(e.getId(),e.getNome(),e.getNumero(),this.cursoRepository.buscarCurso(e.getCurso()))).collect(Collectors.toList());
    // }

    @GetMapping(value = "/curso")
    public ResponseDefault<List<EstudanteCursoProjection>> pesquisarEstudantesCurso() {
        return new ResponseDefault<>(estudanteService.obterEstudantesECursos());
    }

    @PostMapping
    public @ResponseBody Estudante salvar(Estudante estudante) {
        return estudanteService.salvar(estudante);
    }
    @PutMapping
    public @ResponseBody Estudante actualizar(Estudante estudante) {
        return estudanteService.salvar(estudante);
    }
    
}
