package com.homework;
import java.text.SimpleDateFormat;

public class Pracovni_den {
    private String prichod;
    private String odchod;

    public Pracovni_den(String prichod) {
        this.prichod = prichod;
    }

    public Pracovni_den(String prichod, String odchod) {
        this.odchod = odchod;
    }

    public String getPrichod() {
        return prichod;
    }

    public void setPrichod(String prichod) {
        this.prichod = prichod;
    }

    public String getOdchod() {
        return odchod;
    }

    public void setOdchod(String odchod) {
        this.odchod = odchod;
    }
}
