package ru.cbr.dto;

public class RgnDto extends BaseDto {
    private String name;

    public RgnDto() {
    }

    public RgnDto(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
