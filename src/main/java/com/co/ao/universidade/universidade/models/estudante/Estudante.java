package com.co.ao.universidade.universidade.models.estudante;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String numero;
    private int curso;

    public Estudante() {

    }

    public Estudante(String nome){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    
    public int getCurso() {
        return curso;
    }
}
