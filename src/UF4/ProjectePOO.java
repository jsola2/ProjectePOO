package UF4;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectePOO {

    public static void main(String[] args) throws SQLException {
            Scanner in = new Scanner(System.in);
            GestorDades gestor = new GestorDades();

            System.out.println("Escull una opcio: ");
            System.out.println("""
                    Afegir client(1)\s
                    Esborrar client(2)
                    Consultar dades(3)""");

            while (true){
                    int opcio = in.nextInt();
                    switch (opcio) {
                            case 1 -> gestor.afegirClient();
                            case 2-> gestor.esborrarClient();
                            case 3-> gestor.mostrarClient();
                    }
            }


    }
}




