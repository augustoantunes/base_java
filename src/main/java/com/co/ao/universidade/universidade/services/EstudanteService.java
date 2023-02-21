package com.co.ao.universidade.universidade.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.co.ao.universidade.universidade.DTO.estudante.EstudanteCursoProjection;
import com.co.ao.universidade.universidade.models.estudante.Estudante;
import com.co.ao.universidade.universidade.repository.estudante.EstudanteRepository;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Page<Estudante> obterTodosEstudantes(PageRequest pageRequest) {
        return estudanteRepository.findAll(pageRequest);
    }

    public Optional<Estudante> obterEstudante(Integer id) {
        return estudanteRepository.findById(id);
    }

    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public List<EstudanteCursoProjection> obterEstudantesECursos() {
        return estudanteRepository.obterEstudantesECursos();
    }

    public Estudante salvar(Estudante estudante){
        return estudanteRepository.save(estudante);
    }
}
