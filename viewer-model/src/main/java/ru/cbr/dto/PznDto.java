package ru.cbr.dto;

public class PznDto extends BaseDto {

    private String name;

    public PznDto() {
    }

    public PznDto(Long id, String name) {
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
