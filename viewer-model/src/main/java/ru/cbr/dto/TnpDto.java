package ru.cbr.dto;

public class TnpDto extends BaseDto {
    private String fname;

    public TnpDto() {
    }

    public TnpDto(Long id, String fname) {
        super(id);
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
