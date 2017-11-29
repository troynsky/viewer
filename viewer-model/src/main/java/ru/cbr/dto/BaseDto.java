package ru.cbr.dto;

import java.io.Serializable;

public class BaseDto implements Serializable {
    private Long id;

    public BaseDto() {
    }

    public BaseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
