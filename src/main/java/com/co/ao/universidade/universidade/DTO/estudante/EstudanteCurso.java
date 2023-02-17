package com.co.ao.universidade.universidade.DTO.estudante;

import com.co.ao.universidade.universidade.models.curso.Curso;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstudanteCurso {
    private int id;
    private String nome;
    private String numero;
    private Curso curso;
}
