package com.co.ao.universidade.universidade.DTO.response;


public class Pagination {

    private Long rows;
    private Integer page;
    private Integer size;

    public Pagination(Integer size, Long rows) {
        this.size = size;
        this.rows = rows;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRowsTotal(Long rowsTotal) {
        this.rows = rowsTotal;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public Long getRows() {
        return rows;
    }

    public Integer getSize() {
        return size;
    }
}
