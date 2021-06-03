package UF4.model;

public class Persona {
    protected String nom;
    protected String cognom;
    protected String dni;
    protected String poblacio;
    protected String adreca;

    public Persona(String nom, String cognom, String dni, String poblacio, String adreca) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.poblacio = poblacio;
        this.adreca = adreca;
    }

    public Persona() { }

    public Persona(String dni) {
        this.dni = dni;
    }
}
