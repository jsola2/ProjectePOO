package UF4.model;

import UF4.ConectarBaseDades;

import java.sql.*;

public class Producte {
    protected String nom;
    protected float preu;
    protected String codi;
    ConectarBaseDades connect = new ConectarBaseDades();
    Connection connexio = connect.getConnection();

    public Producte(String nom , float preu, String codi){
        this.nom = nom;
        this.preu = preu;
        this.codi = codi;
    }

    public Producte(String codi)  {
        this.codi = codi;
    }

    public Producte() {
        System.out.println("Resultat: ");
    }


    public void afegirProducteBD () throws SQLException {
        int contador = 1;
        PreparedStatement consulta = connexio.prepareStatement("INSERT INTO productes VALUES (?,?,?,?)");
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");

        while(rs.next()) {
            contador++;
        }
        consulta.setInt(1,contador);
        consulta.setString(2,nom);
        consulta.setFloat(4,preu);
        consulta.setString(3,codi);
        consulta.executeUpdate();
    }

    public void borrarProducte () throws SQLException {

        PreparedStatement v = connexio.prepareStatement("DELETE FROM productes WHERE nom = ? AND preu = ? AND codi = ? ");

        v.setString(1,nom);
        v.setFloat(2,preu);
        v.setString(3,codi);
        v.executeUpdate();
    }

    public void mostrarProducteBD() throws SQLException {

        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM productes");
        String nom;
        float preu;
        String codi;

        while(rs.next()) {
            nom = rs.getString("nom");
            preu = rs.getFloat("preu");
            codi = rs.getString("codi");
            System.out.println(nom  + ", " + nom + ", " + preu + ", " + codi);
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




