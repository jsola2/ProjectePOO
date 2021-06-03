package UF4;

import java.sql.*;

public class ConectarBaseDades {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "perepi";
    private static final String password = "password";
    private static final String url = "jdbc:mysql://database-3.c4sehtssjxjr.us-east-1.rds.amazonaws.com/pub";


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


    //este metodo nos retorna la conexion
    public Connection getConnection() {
        return conn;
    }

    //con este metodo nos desconectamos de la base de dades
    public void deconectar() {
        conn = null;
        if (conn == null) {
            Interficie.mostrarMissatge("Connexió tancada...");
        }
    }
}
