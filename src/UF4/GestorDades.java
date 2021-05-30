package UF4;
import UF4.model.clients;

import java.sql.SQLException;
import java.util.Scanner;

public class GestorDades {
    public void afegirClient () throws SQLException {
        Scanner in = new Scanner(System.in);
        clients s = new clients(in.nextLine(), in.nextLine(), in.nextLine(), in.nextBoolean());
        s.afegirClientBD();
    }
    public void esborrarClient () throws SQLException {
        Scanner in = new Scanner(System.in);
        clients s = new clients(in.nextLine(),in.nextLine(),in.nextLine());
        s.borrarClient();
    }
    public void mostrarClient () throws SQLException{
        clients s = new clients();
        s.mostrarClientBD();
    }

}
