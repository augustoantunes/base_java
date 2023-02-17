package com.co.ao.universidade.universidade.repository.curso;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.ao.universidade.universidade.models.curso.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer> {
    @Query(value = "SELECT * from Curso C where C.id=?1",nativeQuery = true)
    public Curso buscarCurso(int curso);
}
