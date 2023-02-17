package com.co.ao.universidade.universidade.DTO.estudante;

import com.co.ao.universidade.universidade.models.curso.Curso;

public interface EstudanteCursoProjection {
    String getNome();
    String getNumero();
    Curso getCurso();
}
