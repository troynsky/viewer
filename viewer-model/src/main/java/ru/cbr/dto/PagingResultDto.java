package ru.cbr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagingResultDto<D> implements Serializable {
    private List<D> list = new ArrayList<>();
    private Long size;

    public PagingResultDto() {
    }

    public PagingResultDto(List<D> aList, long aSize) {
        list = aList;
        size = aSize;
    }

    public List<D> getList() {
        return list;
    }

    public void setList(List<D> aList) {
        list = aList;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long aSize) {
        size = aSize;
    }
}