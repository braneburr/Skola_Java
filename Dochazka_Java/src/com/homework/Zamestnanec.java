package com.homework;

import java.util.ArrayList;

public class Zamestnanec {
    private String jmeno;
    private String prijmeni;
    private Pracovni_zarazeni pracovni_zarazeni;
    private ArrayList<Pracovni_den> dochazka = new ArrayList<Pracovni_den>();

    public Zamestnanec(String jmeno, String prijmeni, Pracovni_zarazeni pracovni_zarazeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.pracovni_zarazeni = pracovni_zarazeni;
    }

    public String getJmeno() {
        return this.jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return this.prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public Pracovni_zarazeni getPracovni_zarazeni() {
        return this.pracovni_zarazeni;
    }

    public void setPracovni_zarazeni(Pracovni_zarazeni pracovni_zarazeni) {
        this.pracovni_zarazeni = pracovni_zarazeni;
    }

    public ArrayList<Pracovni_den> getDochazka() {
        return dochazka;
    }

    public void setDochazka(ArrayList<Pracovni_den> dochazka) {
        this.dochazka = dochazka;
    }

    public String getDochazkaStr() {
        String output = "";

        if (!(this.dochazka.isEmpty())) {
            for (Pracovni_den den : this.dochazka) {
                if (den.getPrichod() != null)
                    output += (("\nPrichod: ") + den.getPrichod() + "\n");

                if (den.getOdchod() != null)
                    output += ("Odchod: " + den.getOdchod() + "\n");
            }
        }

        return output;
    }

    public void prichodDoPrace(String datumACas) {
            dochazka.add(new Pracovni_den(datumACas));
    }

    public void odchodZPrace(String datumACas) {
        dochazka.get(dochazka.size() - 1).setOdchod(datumACas);
    }

}
