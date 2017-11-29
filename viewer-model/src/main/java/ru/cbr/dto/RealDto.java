package ru.cbr.dto;

public class RealDto extends BaseDto {

    private String real;

    public RealDto() {
    }

    public RealDto(Long id, String real) {
        super(id);
        this.real = real;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }
}
