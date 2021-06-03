package UF4.model;

import UF4.ConectarBaseDades;
import UF4.Interficie;

import java.sql.*;
import java.util.Objects;


public class Clients extends Persona {

    protected boolean clientVip;

    ConectarBaseDades connect = new ConectarBaseDades();
    Connection s = connect.getConnection();

    public Clients(String nom , String cognoms, String dni, boolean clientVip){
        super(nom,cognoms,dni);
        this.nom = nom;
        this.cognom = cognoms;
        this.dni = dni;
        this.clientVip = clientVip;
    }

    public Clients(String nomBorrar, String cognomsBorrar, String dniBorrar)  {
        super(nomBorrar,cognomsBorrar,dniBorrar);
        this.nom = nomBorrar;
        this.cognom = cognomsBorrar;
        this.dni = dniBorrar;
    }

    public Clients() {
        super();
        Interficie.mostrarMissatge("Resultat: ");
    }


    public void afegirClientBD () throws SQLException {
        int client_id = 0;
        PreparedStatement v = s.prepareStatement("INSERT INTO clients VALUES (?,?,?,?,?)");

        Statement stmt=s.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");

        while(rs.next()) {
            client_id = rs.getInt("client_id");
        }
        v.setInt(1,client_id+1);
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
            Interficie.mostrarMissatge(nom  + ", " + cognom + ", " + dni + ", " + clientVip);
        }

        s.close();
    }

    public void mostrarClientPerNomBD(String nomClient, String dniClient) throws SQLException {
        Statement stmt=s.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
        String nom;
        String cognom;
        String dni;
        boolean clientVip;
        String resultat = null;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            clientVip = rs.getBoolean("clientVip");

            if (nomClient.equals(nom) && dni.equals(dniClient)){
                resultat = (nom  + ", " + cognom + ", " + dni + ", " + clientVip);
            }
        }
        Interficie.mostrarMissatge(Objects.requireNonNullElse(resultat, "No s'ha trobat el client"));
        s.close();
    }

    public void mostrarClientsVipBD () throws SQLException {
        Statement stmt=s.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
        String nom;
        String cognom;
        String dni;
        boolean clientVip;
        String resultat = "";

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            clientVip = rs.getBoolean("clientVip");

            if (clientVip){
                resultat = (nom  + ", " + cognom + ", " + dni + ", " + clientVip) + "\n" + resultat;
            }
        }

        if (resultat.equals("")){
            Interficie.mostrarMissatge("No s'ha trobat ningun client vip");
        } else {
            Interficie.mostrarMissatge(resultat);
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
