package UF4.model;

import UF4.ConectarBaseDades;
import UF4.Interficie;

import java.sql.*;

public class Producte {
    protected String nom;
    protected float preu;
    protected String codi;
    protected String marca;
    protected String descripcio;
    ConectarBaseDades connect = new ConectarBaseDades();
    Connection connexio = connect.getConnection();

    public Producte(String nom , float preu, String codi, String marca, String descripcio){
        this.nom = nom;
        this.preu = preu;
        this.codi = codi;
        this.marca = marca;
        this.descripcio = descripcio;
    }

    public Producte(String codi)  {
        this.codi = codi;
    }

    public Producte() {
    }


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

    public void borrarProducte () throws SQLException {

        PreparedStatement consulta = connexio.prepareStatement("DELETE FROM productes WHERE codi = ? ");

        consulta.setString(1,codi);
        consulta.executeUpdate();
    }

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




