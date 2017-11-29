package ru.cbr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tnp")
public class TNP extends BaseEntity {

    @Column(name = "vkey", length = 2, unique = true)
    private String vkey;

    @Column(name = "tnp", length = 2)
    private String tnp;

    @Column(name = "full_name", length = 25)
    private String fullName;

    @Column(name = "short_name", length = 5)
    private String shortName;

    public TNP() {
    }

    public TNP(String vkey, String tnp, String fullName, String shortName) {
        this.vkey = vkey;
        this.tnp = tnp;
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
