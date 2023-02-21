package com.co.ao.universidade.universidade.util;

import java.io.IOException;
import java.lang.reflect.Field;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseDefault<T> {

    /**
     * @param data
     */
    public ResponseDefault(T data) {

        try {
            @SuppressWarnings("unchecked")
            Page<Object>  objectPage = (Page<Object>) utilJackson.jsonToObjectBody(data, RestResponsePage.class);
            this.data = objectPage.getContent();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Object objectPage = (Object) process(this.data, RestResponsePage.class);

    }

    private Object data;
    private Integer linhas;

    public Object getData() {

        return this.data;
    }

    public Integer getLinhas() {
        return linhas;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasField(Object object, String fieldName) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                return true;
            }
        }
        return false;
    }

    public Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    public Object process(String input, Class outputType) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(input);
        return mapper.readValue(json, outputType);
    }

}