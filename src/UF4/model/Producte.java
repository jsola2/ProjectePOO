package UF4.model;

import java.util.ArrayList;
import java.util.Scanner;

class Producte {
    private String nom;
    private Float preu;
    private String codi;


    public Producte(String nom, float preu, String codi) {
        this.nom = nom;
        this.preu = preu;
        this.codi = codi;

    }

    public String getNom() {
        return nom;
    }

    public Float getPreu() {
        return preu;
    }

    public String getCodi() {
        return codi;
    }
}



