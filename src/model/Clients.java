package model;

public class Clients {
    private String nom;
    private String cogomns;
    private String dni;
    private boolean clientVip;


    public Clients(String nom, String cogomns, String dni, boolean clientVip) {
        this.nom = nom;
        this.cogomns = cogomns;
        this.dni = dni;
        this.clientVip = clientVip;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCogomns() {
        return cogomns;
    }

    public void setCogomns(String cogomns) {
        this.cogomns = cogomns;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isClientVip() {
        return clientVip;
    }

    public void setClientVip(boolean clientVip) {
        this.clientVip = clientVip;
    }
}
