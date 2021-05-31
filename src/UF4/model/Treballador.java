package UF4.model;

import java.sql.*;
import java.util.Scanner;
import UF4.ConectarBaseDades;

public class Treballador {

    private String nom;
    private String cognom;
    private String dni;
    private int categoria;
    ConectarBaseDades connect = new ConectarBaseDades();
    Connection conexio = connect.getConnection();

    public Treballador(String nom, String cognom, String dni,int categoria) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.categoria = categoria;
    }
    public Treballador(String nomEsborrar, String cognomEsborrar, String dniEsborrar) {

        this.nom = nomEsborrar;
        this.cognom = cognomEsborrar;
        this.dni = dniEsborrar;
    }
    public Treballador() {



    }
    @Override
    public String toString() {
        return "Treballador{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", dni='" + dni + '\'' +
                ", categoria=" + categoria +
                '}';
    }


    enum tipusDempleat {


        NETEJA(1),
        CAMBRER(2),
        BARMAN(3);

        tipusDempleat(int categoria) {
        }
    }
    public void afegirTreballadorBD() throws SQLException {
        int count = 0;
        Statement stmt = conexio.createStatement();
        PreparedStatement insertar = conexio.prepareStatement( "INSERT INTO empleats VALUES (?,?,?,?,?)");


        ResultSet resultat = stmt.executeQuery("SELECT * FROM empleats");
        ResultSet sel = stmt.executeQuery("SELECT count(empleat_id) FROM empleats");

        while(resultat.next()){
            count++;
        }
        //consulta.setInt(1,count);
        insertar.setString(2,nom);
        insertar.setString(3,cognom);
        insertar.setString(4,dni);
        insertar.setInt(5,categoria);
    }
    public void esborrarTreballadorBD() throws SQLException {

        Statement stmt = conexio.createStatement();

        PreparedStatement esborrar = conexio.prepareStatement("DELETE FROM empleats WHERE dni = ?");

        esborrar.setString(1,dni);

    }
    public void mostrarTreballadorBD() throws  SQLException {

        Statement stmt = conexio.createStatement();
        ResultSet mostrar = stmt.executeQuery("SELECT * FROM empleats");

        while (mostrar.next()){
            nom = mostrar.getString("nom");
            cognom = mostrar.getString("cognom");
            dni = mostrar.getString("dni");
            categoria = mostrar.getInt("categoria");
            System.out.println(nom  + ", " + cognom + ", " + dni + ", " + categoria);
        }

    }

}