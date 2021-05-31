package UF4.model;

import UF4.ConectarBaseDades;

import java.sql.*;


public class clients {
    protected String nom;
    protected String cognom;
    protected String dni;
    protected boolean clientVip;

    ConectarBaseDades connect = new ConectarBaseDades();
    Connection s = connect.getConnection();

    public clients(String nom , String cognoms, String dni, boolean clientVip){
        this.nom = nom;
        this.cognom = cognoms;
        this.dni = dni;
        this.clientVip = clientVip;
    }

    public clients(String nomBorrar, String cognomsBorrar, String dniBorrar)  {
        this.nom = nomBorrar;
        this.cognom = cognomsBorrar;
        this.dni = dniBorrar;
    }

    public clients() {
        System.out.println("Resultat: ");
    }


    public void afegirClientBD () throws SQLException {
        int contador = 1;
        PreparedStatement v = s.prepareStatement("INSERT INTO clients VALUES (?,?,?,?,?)");

        Statement stmt=s.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");

        while(rs.next()) {
            contador++;
        }
        v.setInt(1,contador);
        v.setString(2,nom);
        v.setString(3,cognom);
        v.setString(4,dni);
        v.setBoolean(5,clientVip);
        v.executeUpdate();
    }

    public void borrarClient () throws SQLException {

        PreparedStatement v = s.prepareStatement("DELETE FROM clients WHERE nom = ? AND cognom = ? AND dni = ? ");

        v.setString(1,nom);
        v.setString(2,cognom);
        v.setString(3,dni);
        v.executeUpdate();
    }

    public void mostrarClientBD () throws SQLException {

        Statement stmt=s.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
        String nom;
        String cognom;
        String dni;
        boolean clientVip;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            clientVip = rs.getBoolean("clientVip");
            System.out.println(nom  + ", " + cognom + ", " + dni + ", " + clientVip);
        }

        s.close();
    }


    @Override
    public String toString() {
        return "clients{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", dni='" + dni + '\'' +
                ", clientVip=" + clientVip +
                '}';
    }
}
