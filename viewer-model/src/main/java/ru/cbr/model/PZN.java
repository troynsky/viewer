package ru.cbr.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pzn")
public class PZN extends BaseEntity{
    @Column(name = "vkey", length = 2, unique = true)
    private String vkey;

    @Column(name = "pzn", length = 2)
    private String pzn;

    @Column(name = "imy", length = 4)
    private String imy;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "cb_date")
    @Temporal(TemporalType.DATE)
    private Date cb_date;

    @Column(name = "ce_date")
    @Temporal(TemporalType.DATE)
    private Date ce_date;

    public PZN() {
    }

    public PZN(String vkey, String pzn, String imy, String name, Date cb_date, Date ce_date) {
        this.vkey = vkey;
        this.pzn = pzn;
        this.imy = imy;
        this.name = name;
        this.cb_date = cb_date;
        this.ce_date = ce_date;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public String getPzn() {
        return pzn;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }

    public String getImy() {
        return imy;
    }

    public void setImy(String imy) {
        this.imy = imy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCb_date() {
        return cb_date;
    }

    public void setCb_date(Date cb_date) {
        this.cb_date = cb_date;
    }

    public Date getCe_date() {
        return ce_date;
    }

    public void setCe_date(Date ce_date) {
        this.ce_date = ce_date;
    }
}
