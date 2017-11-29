package ru.cbr.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bnkseek")
public class BNKSEEK extends BaseEntity {
//    , unique = true, nullable = false, insertable = false, updatable = false

    @Column(name = "vkey", length = 8, unique = true)
    private String vkey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "real")
    private REAL real;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pzn")
    private PZN pzn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uer", nullable = false)
    private UER uer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rgn", nullable = false)
    private REG rgn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tnp")
    private TNP tnp;

    @Column(name = "ind", length = 6)
    private String ind;

    @Column(name = "nnp", length = 25)
    private String nnp;

    @Column(name = "adr", length = 30)
    private String adr;

    @Column(name = "rkc", length = 9)
    private String rkc;

    @Column(name = "namep", length = 45, nullable = false)
    private String namep;

    @Column(name = "namen", length = 30, nullable = false)
    private String namen;

    @Column(name = "newnum", length = 9, unique = true)
    private String newnum;

    @Column(name = "newks", length = 9)
    private String newks;

    @Column(name = "permfo", length = 6)
    private String permfo;

    @Column(name = "srok", length = 2, nullable = false)
    private String srok;

    @Column(name = " at1", length = 7)
    private String at1;

    @Column(name = "at2", length = 7)
    private String at2;

    @Column(name = "telef", length = 25)
    private String telef;

    @Column(name = "regn", length = 9)
    private String regn;

    @Column(name = "okpo", length = 8)
    private String okpo;

    @Column(name = "dt_izm", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtIzm;

    @Column(name = "cks", length = 6)
    private String cks;

    @Column(name = "ksnp", length = 20)
    private String ksnp;

    @Column(name = "date_in", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @Column(name = "date_ch")
    @Temporal(TemporalType.DATE)
    private Date dateCh;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "vkey")
    private BNKSEEK vkeyDel;

    @Column(name = "dt_izmr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtIzmr;

    public BNKSEEK() {
    }

    public BNKSEEK(String vkey, REAL real, PZN pzn, UER uer, REG rgn, TNP tnp, String ind, String nnp, String adr, String rkc, String namep, String namen, String newnum, String newks, String permfo, String srok, String at1, String at2, String telef, String regn, String okpo, Date dtIzm, String cks, String ksnp, Date dateIn, Date dateCh, BNKSEEK vkeyDel, Date dtIzmr) {
        this.vkey = vkey;
        this.real = real;
        this.pzn = pzn;
        this.uer = uer;
        this.rgn = rgn;
        this.tnp = tnp;
        this.ind = ind;
        this.nnp = nnp;
        this.adr = adr;
        this.rkc = rkc;
        this.namep = namep;
        this.namen = namen;
        this.newnum = newnum;
        this.newks = newks;
        this.permfo = permfo;
        this.srok = srok;
        this.at1 = at1;
        this.at2 = at2;
        this.telef = telef;
        this.regn = regn;
        this.okpo = okpo;
        this.dtIzm = dtIzm;
        this.cks = cks;
        this.ksnp = ksnp;
        this.dateIn = dateIn;
        this.dateCh = dateCh;
        this.vkeyDel = vkeyDel;
        this.dtIzmr = dtIzmr;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public REAL getReal() {
        return real;
    }

    public void setReal(REAL real) {
        this.real = real;
    }

    public PZN getPzn() {
        return pzn;
    }

    public void setPzn(PZN pzn) {
        this.pzn = pzn;
    }

    public UER getUer() {
        return uer;
    }

    public void setUer(UER uer) {
        this.uer = uer;
    }

    public REG getRgn() {
        return rgn;
    }

    public void setRgn(REG rgn) {
        this.rgn = rgn;
    }

    public TNP getTnp() {
        return tnp;
    }

    public void setTnp(TNP tnp) {
        this.tnp = tnp;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getRkc() {
        return rkc;
    }

    public void setRkc(String rkc) {
        this.rkc = rkc;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getNamen() {
        return namen;
    }

    public void setNamen(String namen) {
        this.namen = namen;
    }

    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum;
    }

    public String getNewks() {
        return newks;
    }

    public void setNewks(String newks) {
        this.newks = newks;
    }

    public String getPermfo() {
        return permfo;
    }

    public void setPermfo(String permfo) {
        this.permfo = permfo;
    }

    public String getSrok() {
        return srok;
    }

    public void setSrok(String srok) {
        this.srok = srok;
    }

    public String getAt1() {
        return at1;
    }

    public void setAt1(String at1) {
        this.at1 = at1;
    }

    public String getAt2() {
        return at2;
    }

    public void setAt2(String at2) {
        this.at2 = at2;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getRegn() {
        return regn;
    }

    public void setRegn(String regn) {
        this.regn = regn;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public Date getDtIzm() {
        return dtIzm;
    }

    public void setDtIzm(Date dtIzm) {
        this.dtIzm = dtIzm;
    }

    public String getCks() {
        return cks;
    }

    public void setCks(String cks) {
        this.cks = cks;
    }

    public String getKsnp() {
        return ksnp;
    }

    public void setKsnp(String ksnp) {
        this.ksnp = ksnp;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateCh() {
        return dateCh;
    }

    public void setDateCh(Date dateCh) {
        this.dateCh = dateCh;
    }

    public BNKSEEK getVkeyDel() {
        return vkeyDel;
    }

    public void setVkeyDel(BNKSEEK vkeyDel) {
        this.vkeyDel = vkeyDel;
    }

    public Date getDtIzmr() {
        return dtIzmr;
    }

    public void setDtIzmr(Date dtIzmr) {
        this.dtIzmr = dtIzmr;
    }
}
