package ru.cbr.dto;

public class UerDto extends BaseDto {
    private String name;

    public UerDto() {
    }

    public UerDto(Long id, String name) {
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
