package UF4.model;

import UF4.ConectarBaseDades;
import UF4.Interficie;

import java.sql.*;
import java.util.Objects;

/**
 *La classe client és la classe on es gestionen els constructors necessaris per implementar les funcionalitats que necessitem per la part de client,
 * i també conté les funcions que ens permeten fer les consultes que nosaltres volem.
 * També aquesta classe hereta paràmetres de la classe persona
 */
public class Clients extends Persona {

    protected boolean clientVip;
    ConectarBaseDades connect = new ConectarBaseDades();
    Connection connexio = connect.getConnection();

    /**
     *Aquest seria el constructor principal amb el qual podem crear nous clients i afegir-los a la base de dades.
     * En aquest constructor tenim els següents paràmetres:
     * @param nom insertem el nom del client
     * @param cognoms insertem el cognom del client
     * @param dni insertem el dni del client
     * @param poblacio insertem la poblacio del client
     * @param adreca insertem la adreça del client
     * @param clientVip insertem aquest parametre per saber si el client es vip o no
     * Aquests paràmetres són heretats de la classe persona.
     */
    public Clients(String nom , String cognoms, String dni,String poblacio, String adreca, boolean clientVip){
        super(nom,cognoms,dni,poblacio,adreca);
        this.nom = nom;
        this.cognom = cognoms;
        this.dni = dni;
        this.poblacio = poblacio;
        this.adreca = adreca;
        this.clientVip = clientVip;
    }

    /**
     * Aquest constructor seria uns dels constructors secundaris
     * el qual ens permet crear l'objecte client per posteriorment
     * poder esborrar-lo de la base de dades amb les funcions implementades.
     * @param nomBorrar insertem el nom del client per després poder esborrar-lo
     * @param cognomsBorrar insertem el cognom del client per després poder esborrar-lo
     * @param dniBorrar insertem el dni del client per després poder esborrar-lo
     */
    public Clients(String nomBorrar, String cognomsBorrar, String dniBorrar)  {
        super(nomBorrar,cognomsBorrar,dniBorrar);
        this.nom = nomBorrar;
        this.cognom = cognomsBorrar;
        this.dni = dniBorrar;

    }

    /**
     * Aquest constructor és un altre dels constructors secundaris que tenim que serveix per realitzar consultes sense necessitat de passar per paràmetre res.
     * Ens mostraria el resultat de les consultes que realitzen les funcions.
     */
    public Clients() {
        super();
        Interficie.mostrarMissatge("Resultat: ");
    }

    /**
     *En aquesta funció el que fem és afegir els clients a la base de dades.
     * Primer de tot el que fem és declarar els paràmetres que necessitàrem per fer l'insert a la taula gràcies al @PreparedStatement. Després necessitàrem crear un @Statement per realitzar la SELECT que necessitàrem.
     * La SELECT està feta de tal forma que quan s'insereixi un nou client, agafa l'últim client_id i li suma 1.
     * Després gràcies al @Set posem l'índex del paràmetre i els valors que hem passat per paràmetre en el constructor.
     * I per últim fem un executeUpdate().
     * @PreparedStatement
     */
    public void afegirClientBD () throws SQLException {

        PreparedStatement consulta = connexio.prepareStatement("INSERT INTO clients VALUES (?,?,?,?,?,?,?)");
        Statement stmt= connexio.createStatement();

        ResultSet rs=stmt.executeQuery("SELECT * FROM clients ORDER BY client_id DESC ");
        rs.next();
        int client_id = rs.getInt("client_id");

        consulta.setInt(1,client_id+1);
        consulta.setString(2,dni);
        consulta.setString(3,nom);
        consulta.setString(4,cognom);
        consulta.setBoolean(5,clientVip);
        consulta.setString(6,poblacio);
        consulta.setString(7,adreca);
        consulta.executeUpdate();
        connect.deconectar();
    }

    /**
     *En aquesta funció el que fem és eliminar els clients de la base de dades.
     * Primer de tot el que fem és declarar els paràmetres que necessitàrem per fer l'insert a la taula gràcies al @PreparedStatement.
     * Després gràcies al @Set posem l'índex del paràmetre i els valors que hem passat per paràmetre en el constructor, i per últim fem un executeUpdate().
     */
    public void borrarClient () throws SQLException {

        PreparedStatement consulta = connexio.prepareStatement("DELETE FROM clients WHERE nom = ? AND cognom = ? AND dni = ?");

        consulta.setString(1,nom);
        consulta.setString(2,cognom);
        consulta.setString(3,dni);
        consulta.executeUpdate();
        connect.deconectar();
    }

    /**
     *En aquesta funció el que fem és mostrar els clients de la base de dades.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades i després les printem gràcies a la funció Interficie.
     */
    public void mostrarClientBD () throws SQLException {

        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
        String nom;
        String cognom;
        String dni;
        boolean clientVip;
        String poblacio;
        String adreca;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            clientVip = rs.getBoolean("clientVip");
            poblacio = rs.getString("poblacio");
            adreca = rs.getString("adreca");
            Interficie.mostrarMissatge("Nom: " + nom  + ", " + "Cognom: " +cognom + ", " + "Dni: " + dni + ", " + "Client Vip: " + clientVip +
                    ", " + "Poblacio: " + poblacio + ", " + "Adreça: " +adreca);
        }

        connect.deconectar();
    }

    /**
     *En aquesta funció el que fem és mostrar els clients de la base de dades filtrats per nom i DNI.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param nomClient l'utilitzem per filtrar les dades
     * @param dniClient l'utilitzem per filtrar les dades
     *
     */
    public void mostrarClientPerNomDniBD(String nomClient, String dniClient) throws SQLException {
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
        String nom;
        String cognom;
        String dni;
        boolean clientVip;
        String poblacio;
        String adreca;
        String resultat = null;

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            clientVip = rs.getBoolean("clientVip");
            adreca = rs.getString("adreca");
            poblacio = rs.getString("poblacio");

            if (nomClient.equals(nom) && dni.equals(dniClient)){
                resultat = ("Nom: " + nom  + ", " + "Cognom: " +cognom + ", " + "Dni: " + dni + ", " + "Client Vip: " + clientVip +
                        ", " + "Poblacio: " + poblacio + ", " + "Adreça: " +adreca);
            }
        }
        Interficie.mostrarMissatge(Objects.requireNonNullElse(resultat, "No s'ha trobat el client"));
        connect.deconectar();

    }

    /**
     *En aquesta funció el que fem és mostrar els clients de la base de dades filtrats per el camp ClientVip. Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades. Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     */
    public void mostrarClientsVipBD () throws SQLException {
        Statement stmt= connexio.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
        String nom;
        String cognom;
        String dni;
        boolean clientVip;
        String poblacio;
        String adreca;
        String resultat = "";

        while(rs.next()) {
            nom = rs.getString("nom");
            cognom = rs.getString("cognom");
            dni = rs.getString("dni");
            clientVip = rs.getBoolean("clientVip");
            adreca = rs.getString("adreca");
            poblacio = rs.getString("poblacio");

            if (clientVip){
                resultat = ("Nom: " + nom  + ", " + "Cognom: " +cognom + ", " + "Dni: " + dni + ", " + "Client Vip: " + clientVip +
                        ", " + "Poblacio: " + poblacio + ", " + "Adreça: " +adreca) + "\n" + resultat;
            }
        }

        if (resultat.equals("")){
            Interficie.mostrarMissatge("No s'ha trobat ningun client vip");
        } else {
            Interficie.mostrarMissatge(resultat);
        }
        connect.deconectar();
    }


    @Override
    public String toString() {
        return "clients{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", dni='" + dni + '\'' +
                ", clientVip=" + clientVip + '\'' +
                ", poblacio=" + poblacio + '\'' +
                ", adreca=" + adreca +
                '}';
    }
}
