package ru.cbr.dto;

import java.util.Date;

public class BnkseekDto extends BaseDto {

    private RealDto real;
    private PznDto pzn;
    private UerDto uer;
    private RgnDto rgn;
    private TnpDto tnp;

    private String ind;
    private String nnp;
    private String adr;
    private String rkc;
    private String namep;
    private String newnum;
    private String telef;
    private String regn;
    private String okpo;
    private Date dtIzm;
    private String ksnp;
    private Date dateIn;
    private Date dateCh;

    public BnkseekDto() {
    }

    public BnkseekDto(Long id, RealDto real, PznDto pzn, UerDto uer, RgnDto rgn, TnpDto tnp, String ind, String nnp, String adr, String rkc, String namep, String newnum, String telef, String regn, String okpo, Date dtIzm, String ksnp, Date dateIn, Date dateCh) {
        super(id);
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
        this.newnum = newnum;
        this.telef = telef;
        this.regn = regn;
        this.okpo = okpo;
        this.dtIzm = dtIzm;
        this.ksnp = ksnp;
        this.dateIn = dateIn;
        this.dateCh = dateCh;
    }

    public RealDto getReal() {
        return real;
    }

    public void setReal(RealDto real) {
        this.real = real;
    }

    public PznDto getPzn() {
        return pzn;
    }

    public void setPzn(PznDto pzn) {
        this.pzn = pzn;
    }

    public UerDto getUer() {
        return uer;
    }

    public void setUer(UerDto uer) {
        this.uer = uer;
    }

    public RgnDto getRgn() {
        return rgn;
    }

    public void setRgn(RgnDto rgn) {
        this.rgn = rgn;
    }

    public TnpDto getTnp() {
        return tnp;
    }

    public void setTnp(TnpDto tnp) {
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

    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum;
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
}
