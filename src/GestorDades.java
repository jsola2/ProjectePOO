
import java.sql.*;

class Conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "perepi";
    private static final String password = "password";
    private static final String url = "jdc:mysql://database-3.c4sehtssjxjr.us-east-1.rds.amazonaws.com";


    public Conectar() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            if (conn != null){
                System.out.println("Conexion establecida...");
            }
        }catch (ClassNotFoundException | SQLException e ){
            System.out.println("Error al concectar " + e );
        }
    }

    //este metodo nos retorna la conexion
    public Connection getConnection (){
        return conn;
    }

    //con este metodo nos desconectamos de la base de dades
    public void deconectar (){
        conn = null;
        if (conn == null){
            System.out.println("Conecion terminada...");
        }
    }
}


public class GestorDades {

    public Object carregarDades;

    public Object getCarregarDades() {
        return carregarDades;
    }

    public Object consultar;
    public Object afegir;

    public Object esborrar;
    public Object sortir;
}


