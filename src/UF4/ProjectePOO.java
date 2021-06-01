package UF4;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectePOO {

    public static void main(String[] args) throws SQLException {


            Scanner in = new Scanner(System.in);
            GestorDades gestor = new GestorDades();
            boolean fiSubmenuProductes = false;


            while (true){
                    System.out.println("Escull una opcio: ");
                    System.out.println("""
                    Afegir producte(1)
                    Esborrar producte(2)
                    Consultar dades de productes(3)
                    Afegir client(4)\s
                    Esborrar client(5)
                    Consultar dades(6)
                    """);
                    System.out.println("tria opció:");
                    int opcio = in.nextInt();
                    switch (opcio) {
                            case 1 -> gestor.afegirProducte();
                            case 2-> gestor.esborrarProducte();
                            case 3-> {
                                    while (!fiSubmenuProductes){
                                            System.out.println("""
                                            Filtar per nom(1)
                                            Filtrar per preu(2)
                                            Filtrar per codi(3)
                                            Sense filtrat(4)\s
                                            Sortir (5)
                                            """);
                                            System.out.println("tria opció:");
                                            int opcioSubmenuProducte = in.nextInt();
                                            switch (opcioSubmenuProducte){
                                                    case 1-> gestor.mostrarProductePerNom();
                                                    case 2-> gestor.mostrarProductePerPreu();
                                                    case 3-> gestor.mostrarProductePerCodi();
                                                    case 4->gestor.mostrarProducte();
                                                    case 5->fiSubmenuProductes = true;
                                            }
                                    }
                            }
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




