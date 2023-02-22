package com.co.ao.universidade.universidade.controllers.estudante;

import java.util.List;
import java.util.Optional;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.ao.universidade.universidade.DTO.estudante.EstudanteCurso;
import com.co.ao.universidade.universidade.DTO.estudante.EstudanteCursoProjection;
import com.co.ao.universidade.universidade.models.estudante.Estudante;
import com.co.ao.universidade.universidade.services.EstudanteService;
import com.co.ao.universidade.universidade.util.ResponseDefault;

@RestController
@RequestMapping("estudante")
public class ControllerEstudante {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseDefault<Page<Estudante>> buscarAlunosPaginado(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String order) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString("ASC"), order);
        return new ResponseDefault<>(estudanteService.obterTodosEstudantes(pageRequest));
    }

    @GetMapping(path = "/{id}")
    public ResponseDefault<Optional<Estudante>> detalheEstudante(@PathVariable int id) {
        return new ResponseDefault<>(estudanteService.obterEstudante(id));
    }

    // @GetMapping(value = "/curso")
    // public Iterable<EstudanteCurso> pesquisarEstudantesAll(
    // @RequestParam(required = false, defaultValue = "0") int page,
    // @RequestParam(required = false, defaultValue = "10") int size,
    // @RequestParam(required = false, defaultValue = "id") String order
    // ) {
    // ResponseDefault<Estudante> estudantes = estudanteRepository.findAll();
    // return estudantes.stream().map(e -> new
    // EstudanteCurso(e.getId(),e.getNome(),e.getNumero(),this.cursoRepository.buscarCurso(e.getCurso()))).collect(Collectors.toList());
    // }

    @GetMapping(value = "/curso")
    public ResponseDefault<List<EstudanteCursoProjection>> pesquisarEstudantesCurso() {
        return new ResponseDefault<>(estudanteService.obterEstudantesECursos());
    }

    @PostMapping
    public ResponseDefault<Estudante> salvar(Estudante estudante) {
        Estudante response = estudanteService.salvar(estudante);
        return new ResponseDefault<>(response);
    }

    @PutMapping
    public ResponseDefault<Estudante> actualizar(Estudante estudante) {
        return new ResponseDefault<>(estudanteService.salvar(estudante));
    }

}
