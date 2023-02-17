package com.co.ao.universidade.universidade.models.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    
    @Column(name = "ano_duracao")
    private int anoDuracao;

    public Curso(){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public int getAnoDuracao() {
        return anoDuracao;
    }

    public void setAnoDuracao(int anoDuracao) {
        this.anoDuracao = anoDuracao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
}
