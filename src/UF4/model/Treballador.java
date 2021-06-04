package UF4.model;

import java.sql.*;

import UF4.ConectarBaseDades;
import UF4.Interficie;

/**
 *En aquest enum el que fem és posar el tipus de treballador que tenim en el pub, per després utilitzar-lo en la classe de treballador.
 */
enum TipusDempleat {
    NETEJA,
    CAMBRER,
    BARMAN;
}

/**
 *La classe treballador és la classe on es gestionen els constructors necessaris per implementar les funcionalitats que necessitem per la part de treballador,
 * i també conté les funcions que ens permeten fer les consultes que nosaltres volem.
 * També aquesta classe hereta paràmetres de la classe persona
 */
public class Treballador extends Persona {
    Interficie Interficie = new Interficie();
    private TipusDempleat categoria;

    ConectarBaseDades connect = new ConectarBaseDades();
    Connection connexio = connect.getConnection();

    /**
     *Aquest seria el constructor principal amb el qual podem crear nous Treballadors i afegir-los a la base de dades.
     *En aquest constructor tenim els següents paràmetres:
     * @param nom instertem el nom del traballador
     * @param cognom insertem el cognom del treballador
     * @param dni insertem el dni del treballador
     * @param poblacio insertem la poblacio del treballdor
     * @param adreca insertem la adreca del treballador
     * @param cat aquesta parametre seveix per saaber quien tipues de treballador es cada treballador.
     */
    public Treballador(String nom, String cognom, String dni, String poblacio,String adreca, int cat) {
        super(nom, cognom, dni, poblacio, adreca);
        if (cat == 1) {
            categoria = TipusDempleat.NETEJA;
        } else if (cat == 2) {
            categoria = TipusDempleat.CAMBRER;
        } else if (cat == 3) {
            categoria = TipusDempleat.BARMAN;
        }
    }

    public Treballador() {
    }

    /**
     * Aquest constructor és secundari i l'utilitzem en la classe treballador.
     * @param dni parametre que utlitzarem en les clases filles
     */
    public Treballador(String dni) {
        super(dni);
    }

    @Override
    public String toString() {
        return "Treballador{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", dni='" + dni + '\'' +
                ", categoria=" + categoria + '\'' +
                ", poblacio='" + poblacio + '\'' +
                ", adreca='" + adreca +
                '}';
    }

    /**
     *En aquesta funció el que fem és afegir els treballadors a la base de dades.
     * Primer de tot el que fem és declarar els paràmetres que necessitàrem per fer l'insert a la taula gràcies al @PreparedStatement. Després necessitàrem crear un @Statement per realitzar la SELECT que necessitàrem.
     * La SELECT està feta de tal forma que quan s'insereixi un nou treballador, agafa l'últim empleat_id i li suma 1.
     * Després gràcies al @Set posem l'índex del paràmetre i els valors que hem passat per paràmetre en el constructor.
     * I per últim fem un executeUpdate().
     */
    public void afegirTreballadorBD() throws SQLException {
        int empleat_id = 0;
        Statement stmt = connexio.createStatement();
        PreparedStatement insertar = connexio.prepareStatement("INSERT INTO empleats VALUES (?,?,?,?,?,?,?)");


        ResultSet resultat = stmt.executeQuery("SELECT * FROM empleats");

        while (resultat.next()) {
            empleat_id = resultat.getInt("empleat_id");

        }
        insertar.setInt(1, empleat_id + 1);
        insertar.setString(2, nom);
        insertar.setString(3, cognom);
        insertar.setString(4, dni);
        insertar.setString(5, String.valueOf(categoria));
        insertar.setString(6,poblacio);
        insertar.setString(7,adreca);
        insertar.executeUpdate();

        connexio.close();
    }

    /**
     *En aquesta funció el que fem és eliminar els treballadors de la base de dades.
     * Primer de tot el que fem és declarar els paràmetres que necessitàrem per fer l'insert a la taula gràcies al @PreparedStatement.
     * Després gràcies al @Set posem l'índex del paràmetre i els valors que hem passat per paràmetre en el constructor, i per últim fem un executeUpdate().
     */
    public void esborrarTreballadorBD() throws SQLException {
        try {
            PreparedStatement esborrar = connexio.prepareStatement("DELETE FROM empleats WHERE dni = ?");

            esborrar.setString(1, dni);
            esborrar.executeUpdate();
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els treballadors de la base de dades.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades i després les printem gràcies a la funció Interficie.
     */
    public void mostrarTreballadorBD() throws SQLException {
        try {


            Statement stmt = connexio.createStatement();
            ResultSet mostrar = stmt.executeQuery("SELECT * FROM empleats");

            while (mostrar.next()) {
                nom = mostrar.getString("nom");
                cognom = mostrar.getString("cognom");
                dni = mostrar.getString("dni");
                categoria = TipusDempleat.valueOf(mostrar.getString("categoria"));
                poblacio = mostrar.getString("poblacio");
                adreca = mostrar.getString("adreca");
                Interficie.mostrarMissatge("Nom: " + nom + ", " + " Cognom: " + cognom + ", " + " DNI: " + dni + ", " + " Categoria: " + categoria + " Poblacio: " + poblacio + " Adreça: " + adreca);
            }
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els treballadors de la base de dades filtrats per nom
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pnom l'utilitzem per filtrar.
     */
    public void mostrarTreballadorPerNom(String pnom) throws SQLException {
        try {
            Statement stmt = connexio.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleats");
            String nom;
            String cognom;
            String dni;
            String categoria;
            String poblacio;
            String adreca;

            while (rs.next()) {
                nom = rs.getString("nom");
                cognom = rs.getString("cognom");
                dni = rs.getString("dni");
                categoria = rs.getString("categoria");
                poblacio = rs.getString("poblacio");
                adreca = rs.getString("adreca");
                if (pnom.equalsIgnoreCase(nom)) {
                    Interficie.mostrarMissatge("Nom: " + nom + ", " + " Cognom: " + cognom + ", " + " DNI: " + dni + ", " + " Categoria: " + categoria + " Població: " + poblacio + " Adreça: " + adreca);
                }
            }
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els treballadors de la base de dades filtrats per cognom.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pCognom l'utilitzem per cognom
     */
    public void mostrarTreballadorCognom(String pCognom) throws SQLException {
        try {


            Statement stmt = connexio.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleats");
            String nom;
            String cognom;
            String dni;
            String categoria;
            String poblacio;
            String adreca;

            while (rs.next()) {
                nom = rs.getString("nom");
                cognom = rs.getString("cognom");
                dni = rs.getString("dni");
                categoria = rs.getString("categoria");
                poblacio = rs.getString("poblacio");
                adreca = rs.getString("adreca");
                if (pCognom.equalsIgnoreCase(cognom)) {
                    Interficie.mostrarMissatge("Nom: " + nom + ", " + " Cognom: " + cognom + ", " + " DNI: " + dni + ", " + " Categoria: " + categoria + " Poblacio: " + poblacio + " Adreça: " + adreca);
                }
            }
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els treballadors de la base de dades filtrats per DNI.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pDni l'utilitzem per filtrar
     */
    public void mostrarTreballadorPerDni(String pDni) throws SQLException {
        try {
            Statement stmt = connexio.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleats");
            String nom;
            String cognom;
            String dni;
            String categoria;
            String poblacio;
            String adreca;

            while (rs.next()) {
                nom = rs.getString("nom");
                cognom = rs.getString("cognom");
                dni = rs.getString("dni");
                categoria = rs.getString("categoria");
                poblacio = rs.getString("poblacio");
                adreca = rs.getString("adreca");
                if (pDni.equalsIgnoreCase(dni)) {
                    Interficie.mostrarMissatge("Nom: " + nom + ", " + " Cognom: " + cognom + ", " + " DNI: " + dni + ", " + " Categoria: " + categoria + " Poblacio: " + poblacio + " Adreça: " + adreca);
                }
            }
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }

    /**
     *En aquesta funció el que fem és mostrar els categoria de la base de dades filtrats per categoria.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pCategoria l'utilitzem per filtrar
     */
    public void mostrarTreballadorPerCategoria(String pCategoria) throws SQLException {
        try {


            Statement stmt = connexio.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleats");
            String nom;
            String cognom;
            String dni;
            String categoria;
            String poblacio;
            String adreca;

            while (rs.next()) {
                nom = rs.getString("nom");
                cognom = rs.getString("cognom");
                dni = rs.getString("dni");
                categoria = rs.getString("categoria");
                poblacio = rs.getString("poblacio");
                adreca = rs.getString("adreca");
                if (pCategoria.equalsIgnoreCase(categoria)) {
                    Interficie.mostrarMissatge("Nom: " + nom + ", " + " Cognom: " + cognom + ", " + " DNI: " + dni + ", " + " Categoria: " + categoria + " Poblacio: " + poblacio + " Adreça: " + adreca);
                }
            }
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }

    /**
     * Funcio que te tots els mecanismes per poder filtrar per població introduint-la per parametre.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pPoblacio variable introduida per parametre
     */
    public void mostrarTreballadorPerPoblacio(String pPoblacio) throws SQLException{
        try {


            Statement stmt = connexio.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleats");
            String nom;
            String cognom;
            String dni;
            String categoria;
            String poblacio;
            String adreca;

            while (rs.next()) {
                nom = rs.getString("nom");
                cognom = rs.getString("cognom");
                dni = rs.getString("dni");
                categoria = rs.getString("categoria");
                poblacio = rs.getString("poblacio");
                adreca = rs.getString("adreca");
                if (pPoblacio.equalsIgnoreCase(poblacio)) {
                    Interficie.mostrarMissatge("Nom: " + nom + ", " + " Cognom: " + cognom + ", " + " DNI: " + dni + ", " + " Categoria: " + categoria + " Poblacio: " + poblacio + " Adreça: " + adreca);
                }
            }
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }

    /**
     * Aquesta finció serveix per que es pugui filtrar per adreça, introduïnt aquesta per parametre.
     * Primer de tot el que fem és declarar els paràmetres i variables que necessitàrem per fer la consulta a la base de dades, també passem per paràmetres que necessitem per realitzar la filtració.
     * Després gràcies al bucle while, el que fem és guardar els valors dins de les variables creades.
     * Després fem un condicional per guardar el client que nosaltres volem per després printar-lo gràcies a la funció Interficie.
     * @param pAdreca variable introduïda per parametre.
     */
    public void mostrarTreballadorPerAdreca(String pAdreca) throws SQLException {
        try {

            Statement stmt = connexio.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleats");
            String nom;
            String cognom;
            String dni;
            String categoria;
            String poblacio;
            String adreca;

            while (rs.next()) {
                nom = rs.getString("nom");
                cognom = rs.getString("cognom");
                dni = rs.getString("dni");
                categoria = rs.getString("categoria");
                poblacio = rs.getString("poblacio");
                adreca = rs.getString("adreca");
                if (pAdreca.equalsIgnoreCase(adreca)) {
                    Interficie.mostrarMissatge("Nom: " + nom + ", " + " Cognom: " + cognom + ", " + " DNI: " + dni + ", " + " Categoria: " + categoria + " Poblacio: " + poblacio + " Adreça: " + adreca);
                }
            }
        } catch (Exception e) {
            Interficie.mostrarMissatge("Error al connectar la base de dades");
        }
        connexio.close();
    }
}