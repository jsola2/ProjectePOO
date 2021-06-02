package UF4.model;

import java.sql.*;

import UF4.ConectarBaseDades;
enum TipusDempleat {

    NETEJA,
    CAMBRER,
    BARMAN;
}
public class Treballador {

    private String nom;
    private String cognom;
    private String dni;
    private TipusDempleat categoria;

    ConectarBaseDades connect = new ConectarBaseDades();
    Connection connexio = connect.getConnection();

    public Treballador(String nom, String cognom, String dni,int cat) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        if (cat == 1){
            categoria = TipusDempleat.NETEJA;
        }else if (cat == 2){
            categoria = TipusDempleat.CAMBRER;
        }else if (cat == 3){
            categoria = TipusDempleat.BARMAN;
        }
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

    public void afegirTreballadorBD() throws SQLException {
        int count = 1;
        Statement stmt = connexio.createStatement();
        PreparedStatement insertar = connexio.prepareStatement( "INSERT INTO empleats VALUES (?,?,?,?,?)");


        ResultSet resultat = stmt.executeQuery("SELECT * FROM empleats");

        while(resultat.next()){
            count++;
        }
        insertar.setInt(1,count);
        insertar.setString(2,nom);
        insertar.setString(3,cognom);
        insertar.setString(4,dni);
        insertar.setString(5, String.valueOf(categoria));
        insertar.executeUpdate();

        connexio.close();
    }
    public void esborrarTreballadorBD() throws SQLException {

        Statement stmt = connexio.createStatement();

        PreparedStatement esborrar = connexio.prepareStatement("DELETE FROM empleats WHERE dni = ?");

        esborrar.setString(1,dni);

        connexio.close();
    }
    public void mostrarTreballadorBD() throws  SQLException {

        Statement stmt = connexio.createStatement();
        ResultSet mostrar = stmt.executeQuery("SELECT * FROM empleats");

        while (mostrar.next()){
            nom = mostrar.getString("nom");
            cognom = mostrar.getString("cognom");
            dni = mostrar.getString("dni");
            categoria = TipusDempleat.valueOf(mostrar.getString("categoria"));
            System.out.println(nom  + ", " + cognom + ", " + dni + ", " + categoria);
        }
        connexio.close();
    }
    public void mostrarTreballadorPerNom(String pnom) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM empleats");
        String nom;
        String cognom;
        String dni;
        String categoria;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            categoria = rs.getString("categoria");
            if (pnom.equalsIgnoreCase(nom)) {
                System.out.println(nom  + ", " + cognom + ", " + dni + ", " + categoria);
            }
        }

        connexio.close();
    }

    public void mostrarTreballadorCognom(String pCognom) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM empleats");
        String nom;
        String cognom;
        String dni;
        String categoria;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            categoria = rs.getString("categoria");
            if (pCognom.equalsIgnoreCase(cognom)) {
                System.out.println(nom  + ", " + cognom + ", " + dni + ", " + categoria);
            }
        }

        connexio.close();
    }

    public void mostrarTreballadorPerDni(String pDni) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM empleats");
        String nom;
        String cognom;
        String dni;
        String categoria;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            categoria = rs.getString("categoria");
            if (pDni.equalsIgnoreCase(dni)) {
                System.out.println(nom  + ", " + cognom + ", " + dni + ", " + categoria);
            }
        }

        connexio.close();
    }
    public void mostrarTreballadorPerCategoria(String pCategoria) throws SQLException{
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM empleats");
        String nom;
        String cognom;
        String dni;
        String categoria;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            categoria = rs.getString("categoria");
            if (pCategoria.equalsIgnoreCase(categoria)) {
                System.out.println(nom  + ", " + cognom + ", " + dni + ", " + categoria);
            }
        }

        connexio.close();
    }

}