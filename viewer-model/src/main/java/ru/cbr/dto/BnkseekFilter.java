package ru.cbr.dto;

import java.util.List;

public class BnkseekFilter {
    private Integer bik;
    private String region;
    private List<PznDto> pzns;

    private Integer fromNum;
    private Integer count;
    private String order;

    public BnkseekFilter() {
    }

    public Integer getBik() {
        return bik;
    }

    public void setBik(Integer bik) {
        this.bik = bik;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<PznDto> getPzns() {
        return pzns;
    }

    public void setPzns(List<PznDto> pzns) {
        this.pzns = pzns;
    }

    public Integer getFromNum() {
        return fromNum;
    }

    public void setFromNum(Integer fromNum) {
        this.fromNum = fromNum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
