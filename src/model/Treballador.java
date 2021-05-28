package model;

import java.util.Scanner;

public class Treballador {


    private String nom;
    private String cognom;
    private String dni;
    private int categoria;

    public Treballador(String nom, String cognom, String dni,int categoria) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.categoria = categoria;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getDni() {
        return dni;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }


    enum tipusDempleat {


        NETEJA(1),
        CAMBRER(2),
        BARMAN(3);


        tipusDempleat(int categoria) {

        }


    }


}