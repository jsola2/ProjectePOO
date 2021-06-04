package UF4.model;

/**
 *La classe Persona és la classe on es gestionen els constructors necessaris per implementar les funcionalitats que necessitem per la part de Persona,
 * també és la classe pare, ja que la classe Client i Treballador hereten el paràmetres nom, cognom, dni, poblacio, adreca d'aquesta classe.
 */
public class Persona {
    protected String nom;
    protected String cognom;
    protected String dni;
    protected String poblacio;
    protected String adreca;

    /**
     *Aquest seria el constructor principal amb el qual podem crear noves Persones i gràcies a l'herència, poder afegir-los a la base de dades.
     * En aquest constructor tenim els següents paràmetres:
     * @param nom parametre que utlitzarem en les clases filles
     * @param cognom parametre que utlitzarem en les clases filles
     * @param dni parametre que utlitzarem en les clases filles
     * @param poblacio parametre que utlitzarem en les clases filles
     */
    public Persona(String nom, String cognom, String dni, String poblacio, String adreca) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.poblacio = poblacio;
        this.adreca = adreca;
    }

    /**
     * Aquest constructor és secundari i l'utilitzem en la classe treballador.
     * @param dni parametre que utlitzarem en les clases filles
     */
    public Persona(String dni) {
        this.dni = dni;
    }

    public Persona() { }

    public Persona(String nom, String cognom, String dni) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
    }
}
