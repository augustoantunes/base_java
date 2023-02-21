package com.co.ao.universidade.universidade.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class utilJackson {
     /**
     * Monta o objeto a partir de um arquivo .json localizado no diretorio /resources do test.
     *
     * @param json  {@link String}
     * @param clazz {@link Class}
     * @return Object objeto montado
     * @throws IOException Excecao a ser lancada.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object jsonToObject(String json, Class clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper.readValue(json, clazz);
    }

    @SuppressWarnings("rawtypes")
	public static Object jsonToObjectBody(Object object, Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(object);
        return jsonToObject(jsonString, clazz);
    }

    public static <T> T getDTO(Object dado, Class<T> clazz) {
        return new ObjectMapper().convertValue(dado, clazz);
    }
}
