package UF4.model;

import UF4.ConectarBaseDades;
import UF4.Interficie;
import java.sql.*;

/**
 *La classe Producte és la classe on es gestionen els constructors necessaris per implementar les funcionalitats que necessitem,
 * i també conté les funcions que ens permeten fer les consultes que nosaltres volem.
 */
public class Producte {
    protected String nom;
    protected float preu;
    protected String codi;
    protected String marca;
    protected String descripcio;
    ConectarBaseDades connect = new ConectarBaseDades();
    Connection connexio = connect.getConnection();

    /**
     *
     * @param nom
     * @param preu
     * @param codi
     * @param marca
     * @param descripcio
     */
    public Producte(String nom , float preu, String codi, String marca, String descripcio){
        this.nom = nom;
        this.preu = preu;
        this.codi = codi;
        this.marca = marca;
        this.descripcio = descripcio;
    }

    /**
     *
     * @param codi
     */
    public Producte(String codi)  {
        this.codi = codi;
    }

    public Producte() {
    }


    /**
     *
     * @throws SQLException
     */
    public void afegirProducteBD () throws SQLException {
        int producte_id = 0;
        PreparedStatement consulta = connexio.prepareStatement("INSERT INTO productes VALUES (?,?,?,?,?,?)");
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes ORDER BY producte_id DESC ");
        rs.next();
        producte_id = rs.getInt("producte_id");
        consulta.setInt(1,producte_id+1);
        consulta.setString(2,nom);
        consulta.setFloat(4,preu);
        consulta.setString(3,codi);
        consulta.setString(5,marca);
        consulta.setString(6,descripcio);
        consulta.executeUpdate();
    }

    /**
     *
     * @throws SQLException
     */
    public void borrarProducte () throws SQLException {

        PreparedStatement consulta = connexio.prepareStatement("DELETE FROM productes WHERE codi = ? ");

        consulta.setString(1,codi);
        consulta.executeUpdate();
    }

    /**
     *
     * @throws SQLException
     */
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
     *
     * @param pnom
     * @throws SQLException
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
     * @param pPreu
     * @throws SQLException
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
     *
     * @param pCodi
     * @throws SQLException
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
     *
     * @param pMarca
     * @throws SQLException
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
     *
     * @param pDescripcio
     * @throws SQLException
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




