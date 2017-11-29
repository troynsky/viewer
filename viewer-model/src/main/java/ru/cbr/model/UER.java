package ru.cbr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "uer")
public class UER extends BaseEntity {

    @Column(name = "vkey", length = 2, unique = true)
    private String vkey;

    @Column(name = "uer", length = 1)
    private String uer;

    @Column(name = "uer_name", length = 70)
    private String uerName;

    public UER() {
    }

    public UER(String vkey, String uer, String uerName) {
        this.vkey = vkey;
        this.uer = uer;
        this.uerName = uerName;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public String getUer() {
        return uer;
    }

    public void setUer(String uer) {
        this.uer = uer;
    }

    public String getUerName() {
        return uerName;
    }

    public void setUerName(String uerName) {
        this.uerName = uerName;
    }
}
