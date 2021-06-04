package UF4.model;

import UF4.ConectarBaseDades;
import UF4.Interficie;
import java.sql.*;

/**
 *La classe Producte és la classe on es gestionen els constructors necessaris per implementar les funcionalitats que necessitem,
 * i també conté les funcions que ens permeten fer les consultes que nosaltres volem.
 */
public class Producte implements ProducteInterficie {
    protected String nom;
    protected float preu;
    protected String codi;
    protected String marca;
    protected String descripcio;
    ConectarBaseDades connect = new ConectarBaseDades();
    Connection connexio = connect.getConnection();
    Interficie Interficie = new Interficie();

    /**
     *Aquest seria el constructor principal amb el qual podem crear nous productes i afegir-los a la base de dades.
     * En aquest constructor tenim els següents paràmetres:
     * @param nom insertem el nom del producte
     * @param preu insertem preu del producte
     * @param codi insertem el codi del producte
     * @param marca insertem la marca del producte
     * @param descripcio insertem la descripcio del producte.
     */
    public Producte(String nom , float preu, String codi, String marca, String descripcio){
        this.nom = nom;
        this.preu = preu;
        this.codi = codi;
        this.marca = marca;
        this.descripcio = descripcio;
    }

    /**
     * Aquest constructor és un constructor secundari  que serveix per realitzar consultes amb la necessitat de passar per paràmetre el dni.
     * Ens mostraria el resultat de les consultes que realitzen les funcions amb el paramentre dni.
     * @param codi
     */
    public Producte(String codi)  {
        this.codi = codi;
    }

    public Producte() {
    }


    /**
     *En aquesta funció el que fem és afegir els productes a la base de dades.
     * Primer de tot el que fem és declarar els paràmetres que necessitàrem per fer l'insert a la taula gràcies al @PreparedStatement. Després necessitàrem crear un @Statement per realitzar la SELECT que necessitàrem.
     * La SELECT està feta de tal forma que quan s'insereixi un nou producte, agafa l'últim client_id i li suma 1.
     * Després gràcies al @Set posem l'índex del paràmetre i els valors que hem passat per paràmetre en el constructor.
     * I per últim fem un executeUpdate().
     */
    @Override
    public void afegirProducteBD() throws SQLException {
        PreparedStatement consulta = connexio.prepareStatement("INSERT INTO productes VALUES (?,?,?,?,?,?)");
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes ORDER BY producte_id DESC ");
        rs.next();
        int producte_id = rs.getInt("producte_id");
        consulta.setInt(1,producte_id+1);
        consulta.setString(2,nom);
        consulta.setFloat(4,preu);
        consulta.setString(3,codi);
        consulta.setString(5,marca);
        consulta.setString(6,descripcio);
        consulta.executeUpdate();
    }

    /**
     *En aquesta funció el que fem és eliminar els productes de la base de dades.
     *Primer de tot el que fem és declarar els paràmetres que necessitàrem per fer l'insert a la taula gràcies al @PreparedStatement.
     *Després gràcies al @Set posem l'índex del paràmetre i els valors que hem passat per paràmetre en el constructor, i per últim fem un executeUpdate().
     */
    @Override
    public void borrarProducte() throws SQLException {

        PreparedStatement consulta = connexio.prepareStatement("DELETE FROM productes WHERE codi = ? ");

        consulta.setString(1,codi);
        consulta.executeUpdate();
    }

    /**
     *En aquesta funció el que fem és mostrar els productes de la base de dades.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades i després les printem gràcies a la funció Interficie.
     */
    @Override
    public void mostrarProducteBD() throws SQLException {

        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");
        String nom;
        float preu;
        String codi;
        String marca;
        String descripcio;

        while(rs.next()) {
            nom = rs.getString("nom");
            preu = rs.getFloat("preu");
            codi = rs.getString("codi");
            marca = rs.getString("marca");
            descripcio = rs.getString("descripcio");

            Interficie.mostrarMissatge(" Nom: " + nom  + ", " + " preu: " + preu + ", "+ " codi: " + codi + ", " + " marca: "+ marca +", "+ " descripció: "+ descripcio +  "\n");
        }

        connexio.close();
    }

     /**
     *En aquesta funció el que fem és mostrar els prodcutes de la base de dades filtrats nom
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el producte que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pnom l'utilitzem per filtrar les dades
     *
     */
    public void mostrarProductaFiltratPerNom(String pnom) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");
        String nom;
        float preu;
        String codi;
        String marca;
        String descripcio;

        while(rs.next()) {
            nom = rs.getString("nom");
            preu = rs.getFloat("preu");
            codi = rs.getString("codi");
            marca = rs.getString("marca");
            descripcio = rs.getString("descripcio");
            if (pnom.equalsIgnoreCase( nom)) {
                Interficie.mostrarMissatge(" Nom: " + nom  + ", " + " preu: " + preu + ", "+ " codi: " + codi + ", " + " marca: "+ marca +", "+ " descripció: "+ descripcio +  "\n");
            }
        }

        connexio.close();
    }

    /**
     *
     *En aquesta funció el que fem és mostrar els prodcutes de la base de dades filtrats preu
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el producte que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pPreu l'utilitzem per filtrar les dades
     */
    public void mostrarProductaFiltratPerPreu(float pPreu) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");
        String nom;
        float preu;
        String codi;
        String marca;
        String descripcio;

        while(rs.next()) {
            nom = rs.getString("nom");
            preu = rs.getFloat("preu");
            codi = rs.getString("codi");
            marca = rs.getString("marca");
            descripcio = rs.getString("descripcio");
            if (pPreu == preu) {
                Interficie.mostrarMissatge(" Nom: " + nom  + ", " + " preu: " + preu + ", "+ " codi: " + codi + ", " + " marca: "+ marca +", "+ " descripció: "+ descripcio +  "\n");
            }
        }

        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els prodcutes de la base de dades filtrats codi
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el producte que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pCodi l'utilitzem per filtrar les dades
     */
    public void mostrarProductaFiltratPerCodi(String pCodi) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");
        String nom;
        float preu;
        String codi;
        String marca;
        String descripcio;

        while(rs.next()) {
            nom = rs.getString("nom");
            preu = rs.getFloat("preu");
            codi = rs.getString("codi");
            marca = rs.getString("marca");
            descripcio = rs.getString("descripcio");
            if (pCodi.equals(codi)) {
                Interficie.mostrarMissatge(" Nom: " + nom  + ", " + " preu: " + preu + ", "+ " codi: " + codi + ", " + " marca: "+ marca +", "+ " descripció: "+ descripcio +  "\n");
            }
        }

        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els prodcutes de la base de dades filtrats marca
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el producte que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pMarca l'utilitzem per filtrar les dades
     */
    public void mostrarProductaFiltratPerMarca(String pMarca) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");
        String nom;
        float preu;
        String codi;
        String marca;
        String descripcio;

        while(rs.next()) {
            nom = rs.getString("nom");
            preu = rs.getFloat("preu");
            codi = rs.getString("codi");
            marca = rs.getString("marca");
            descripcio = rs.getString("descripcio");
            if (pMarca.equals(marca)) {
                Interficie.mostrarMissatge(" Nom: " + nom  + ", " + " preu: " + preu + ", "+ " codi: " + codi + ", " + " marca: "+ marca +", "+ " descripció: "+ descripcio +  "\n");
            }
        }

        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els prodcutes de la base de dades filtrats Descripció
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el producte que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pDescripcio l'utilitzem per filtrar les dades
     */
    public void mostrarProductaFiltratPerDescripcio(String pDescripcio) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");
        String nom;
        float preu;
        String codi;
        String marca;
        String descripcio;

        while(rs.next()) {
            nom = rs.getString("nom");
            preu = rs.getFloat("preu");
            codi = rs.getString("codi");
            marca = rs.getString("marca");
            descripcio = rs.getString("descripcio");
            if (pDescripcio.equals(descripcio)) {
                Interficie.mostrarMissatge(" Nom: " + nom  + ", " + " preu: " + preu + ", "+ " codi: " + codi + ", " + " marca: "+ marca +", "+ " descripció: "+ descripcio +  "\n");
            }
        }

        connexio.close();
    }


    @Override
    public String toString() {
        return "Producte{" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", codi='" + codi + '\'' +
                '}';
    }
}




