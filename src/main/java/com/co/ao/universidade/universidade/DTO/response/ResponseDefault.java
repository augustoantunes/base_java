package com.co.ao.universidade.universidade.DTO.response;


public class ResponseDefault<T>  {

    public ResponseDefault( T data ) {
        this.data = data;
        this.linhas = 3;
    }

    private T data;
    private Integer linhas;

    public void setData(T data) {
        this.data = data;
    }

    public void setLinhas(Integer linhas) {
        this.linhas = linhas;
    }

    public T getData() {
        return data;
    }

    public Integer getLinhas() {
        return linhas;
    }

    
}