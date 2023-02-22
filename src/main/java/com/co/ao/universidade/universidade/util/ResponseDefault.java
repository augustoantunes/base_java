package com.co.ao.universidade.universidade.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.co.ao.universidade.universidade.DTO.response.Pagination;

public class ResponseDefault<T> {

    private Object data;
    private Long rowsTotal;
    private Integer page;
    private Integer size;
    private Pagination pagination;

    /**
     * @param data
     */
    public ResponseDefault(T data) {

        if (data != null && data.getClass() != PageImpl.class) {
            this.setData(data);
        } else if (data != null && data.getClass() == PageImpl.class) {
            try {

                @SuppressWarnings("unchecked")
                Page<Object> objectPage = (Page<Object>) utilJackson.jsonToObjectBody(data, RestResponsePage.class);
                if (objectPage.getContent() != null && objectPage.getTotalElements() > 0) {
                    this.setData(objectPage.getContent());
                    Pagination paginator = new Pagination(objectPage.getSize(), objectPage.getTotalElements());
                    this.setPagination(paginator);
                } else {
                    System.out.print(data);
                    this.data = new ArrayList<>();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }


    public void setData(Object data) {
        this.data = data;
    }
    public Object getData() {
        return this.data;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Pagination getPagination() {
        return pagination;
    }


}