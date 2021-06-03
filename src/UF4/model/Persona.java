package UF4.model;

public class Persona {
    protected String nom;
    protected String cognom;
    protected String dni;


    public Persona(String nom, String cognom, String dni) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
    }

    public Persona() { }

    public Persona(String dni) {
        this.dni = dni;
    }
}
