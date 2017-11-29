package ru.cbr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "real")
public class REAL extends BaseEntity {

    @Column(name = "vkey", length = 4, unique = true)
    private String vkey;

    @Column(name = "real", length = 4)
    private String real;

    @Column(name = "name_ogr", length = 60)
    private String name_org;

    public REAL() {
    }

    public REAL(String vkey, String real, String name_org) {
        this.vkey = vkey;
        this.real = real;
        this.name_org = name_org;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public String getName_org() {
        return name_org;
    }

    public void setName_org(String name_org) {
        this.name_org = name_org;
    }
}
