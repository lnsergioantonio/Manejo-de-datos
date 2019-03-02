package com.example.sergio.manejodatos.pojo;

public class Plant {
    private String COMMON;
    private String BOTANICAL;
    private String ZONE;
    private String LIGHT;
    private String PRICE;
    private String AVAILABILITY;

    @Override
    public String toString() {
        return "plant{" +
                //"COMMON='" + COMMON + '\'' +
                ", BOTANICAL='" + BOTANICAL + '\'' +
                //", ZONE='" + ZONE + '\'' +
                //", LIGHT='" + LIGHT + '\'' +
                ", PRICE='" + PRICE + '\'' +
                //", AVAILABILITY='" + AVAILABILITY + '\'' +
                '}';
    }

    public String getCOMMON() {
        return COMMON;
    }

    public void setCOMMON(String COMMON) {
        this.COMMON = COMMON;
    }

    public String getBOTANICAL() {
        return BOTANICAL;
    }

    public void setBOTANICAL(String BOTANICAL) {
        this.BOTANICAL = BOTANICAL;
    }

    public String getZONE() {
        return ZONE;
    }

    public void setZONE(String ZONE) {
        this.ZONE = ZONE;
    }

    public String getLIGHT() {
        return LIGHT;
    }

    public void setLIGHT(String LIGHT) {
        this.LIGHT = LIGHT;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getAVAILABILITY() {
        return AVAILABILITY;
    }

    public void setAVAILABILITY(String AVAILABILITY) {
        this.AVAILABILITY = AVAILABILITY;
    }
}
