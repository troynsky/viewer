package ru.cbr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reg")
public class REG extends BaseEntity {
    @Column(name = "vkey", length = 2, unique = true)
    private String vkey;

    @Column(name = "rgn", length = 2)
    private String rgn;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "center", length = 30)
    private String center;

    @Column(name = "namet", length = 40)
    private String namet;

    public REG() {
    }

    public REG(String vkey, String rgn, String name, String center, String namet) {
        this.vkey = vkey;
        this.rgn = rgn;
        this.name = name;
        this.center = center;
        this.namet = namet;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getNamet() {
        return namet;
    }

    public void setNamet(String namet) {
        this.namet = namet;
    }
}
