package UF4;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectePOO {

    public static void main(String[] args) throws SQLException {


            Scanner in = new Scanner(System.in);
            GestorDades gestor = new GestorDades();

            System.out.println("Escull una opcio: ");
            System.out.println("""
                    Afegir producte(1)
                    Esborrar producte(2)
                    Consultar dades de productes(3)
                    Afegir client(4)\s
                    Esborrar client(5)
                    Consultar dades(6)
                    """);

            while (true){
                    System.out.println("tria opció:");
                    int opcio = in.nextInt();
                    switch (opcio) {
                            case 1 -> gestor.afegirProducte();
                            case 2-> gestor.esborrarProducte();
                            case 3-> gestor.mostrarProducte();
                            case 4 -> gestor.afegirClient();
                            case 5-> gestor.esborrarClient();
                            case 6-> gestor.mostrarClient();
                    }
            }

            /*System.out.println("Benvingut al gestor del pub, seleccioni una opcio" + "\t" + "1- Carregar Dades" + "\t" +
                    "2- Consultar" + "\t" + "3- Afegir" + "\t" + "4- Esborrar" + "\t" + "0- Sortir");
            int menu = in.nextInt();
            do {


                    switch (menu) {
                            // case 1 : gestor.carregarDades();break;
                            //  case 2 : gestor.consultar();break;
                            case 3: gestor.afegir();break;
                            case 4: gestor.esborrar();break;
                            case 0: gestor.sortir();break;
                    }
            }while (menu!=0);*/


    }
}




