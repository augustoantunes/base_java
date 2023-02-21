package com.co.ao.universidade.universidade.DTO.response;

public interface ResponseDefault<T> {
    public T getData();
    public Integer getLinhas();
    public void setData(T data);
    
 
}
