package com.codegym.models;

import java.util.List;

public class StudentResult {
    private List<Student> data;
    private Pagination pagination;

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
