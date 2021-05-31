package UF4;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectePOO {

    public static void main(String[] args) throws SQLException {

            Scanner in = new Scanner(System.in);
            GestorDades gestor = new GestorDades();

            System.out.println("Benvingut al gestor del pub, seleccioni una opcio" + "\t" + "1- Carregar Dades" + "\t" +
                    "2- Consultar" + "\t" + "3- Afegir" + "\t" + "4- Esborrar" + "\t" + "0- Sortir");
            int menu = in.nextInt();
            do {
                    switch (menu) {
                            case 1 : gestor.carregarDades();break;
                            case 2 : gestor.consultar();break;
                            case 3 :
                                    gestor.afegir();break;
                                    System.out.println("Seleccioni el que vols afegir: ");
                                    System.out.println(
                                            "1- Producte" + "\t" +
                                            "2- Client" + "\t" +
                                            "3- Empleat");
                                    int opcio = in.nextInt();
                                    switch (opcio) {
                                            case 1 : gestor.afegirProducte();break;
                                            case 2 : gestor.afegirClient();break;
                                            case 3 : gestor.afegirTreballador();break;
                                    }
                            case 4: gestor.esborrar();break;
                                    System.out.println("Selecciona el que vols esborrar: ");
                                    System.out.println(
                                            "1- Producte" + "\t" +
                                            "2- Client" + "\t" +
                                            "3- Empleat");
                                    int opcio2 = in.nextInt();

                                    switch (opcio2) {
                                            case 1 : gestor.esborrarProducte();break;
                                            case 2 : gestor.esborrarClient();break;
                                            case 3 : gestor.esborrarTreballador();break;
                                    }
                            case 0: break;
                    }
            }while (menu!=0);


    }
}




