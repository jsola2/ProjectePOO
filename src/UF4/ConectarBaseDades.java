package UF4;

import java.sql.*;

/**
 * En la classe base de dades tracta de connectar el Java o millor dit, el codi Java al MySQL.
 * Com podem veure declarem variables estàtiques perquè el codi més net.
 */
public class ConectarBaseDades {
    Interficie Interficie = new Interficie();

    /**
     * Varables estatiques
     */
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "perepi";
    private static final String password = "password";
    private static final String url = "jdbc:mysql://database-3.c4sehtssjxjr.us-east-1.rds.amazonaws.com/pub";


    /**
     * En aquest mètode el que faig és declarar una variable la qual hi ha de connectar-se a la base de dades perquè no sigui null. Si és null llavors saltarà un error.
     */
    public ConectarBaseDades() {

        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                Interficie.mostrarMissatge("Connexió de la base de dades establerta");
            }

        } catch (ClassNotFoundException | SQLException e) {
            Interficie.mostrarMissatge("Error al connectar " + e);
        }
    }


    /**
     * Es el metode que ens retorna la connexió
     * @return retorna la connexió
     */
    public Connection getConnection() {
        return conn;
    }
    /**
     * Amb aquest metode podem desconectarnos de la base de dades
     */
    public void deconectar() {
        conn = null;
        Interficie.mostrarMissatge("Connexió tancada...");
    }
}
