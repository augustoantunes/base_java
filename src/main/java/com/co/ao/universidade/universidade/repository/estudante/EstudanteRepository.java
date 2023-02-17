package com.co.ao.universidade.universidade.repository.estudante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.co.ao.universidade.universidade.models.estudante.Estudante;
import com.co.ao.universidade.universidade.DTO.estudante.EstudanteCursoProjection;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

    @Query(value = "SELECT E, E.nome as nome, C as curso, E.numero as numero FROM Estudante E, Curso C WHERE E.curso = C.id", nativeQuery = false)
    List<EstudanteCursoProjection> obterEstudantesECursos();

}
