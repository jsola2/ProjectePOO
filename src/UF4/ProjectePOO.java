package UF4;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectePOO {

        public static void main(String[] args) throws SQLException {


                Scanner in = new Scanner(System.in);
                GestorDades gestor = new GestorDades();
                boolean fimenu = false;
                boolean fiSubmenuProductes = false;
                boolean fiSubmenuTreballador = false;


                while (!fimenu) {
                        System.out.println("Escull una opcio: ");
                        System.out.println(
                                "1- Afegir producte" + "\n" +
                                        "2- Esborrar producte" + "\n" +
                                        "3- Consultar dades de productes" + "\n" +
                                        "4- Afegir client" + "\n" +
                                        "5- Esborrar client" + "\n" +
                                        "6- Consultar dades de client" + "\n" +
                                        "7- Afegir Treballador" + "\n" +
                                        "8- Esborrar Treballador" + "\n" +
                                        "9- Consultar dades de Treballador" + "\n" +
                                        "0- Sortir"
                        );
                        System.out.println("tria opció:");
                        int opcio = in.nextInt();
                        switch (opcio) {
                                case 1:
                                        gestor.afegirProducte();
                                case 2:
                                        gestor.esborrarProducte();
                                case 3: {
                                        while (!fiSubmenuProductes) {
                                                System.out.println(
                                                        "1- Filtar per nom" + "\n" +
                                                                "2- Filtrar per preu" + "\n" +
                                                                "3- Filtrar per codi" + "\n" +
                                                                "4- Sense filtrat" + "\n" +
                                                                "0- Sortir"
                                                );
                                                System.out.println("tria opció:");
                                                int opcioSubmenuProducte = in.nextInt();
                                                switch (opcioSubmenuProducte) {
                                                        case 1:
                                                                gestor.mostrarProductePerNom();
                                                        case 2:
                                                                gestor.mostrarProductePerPreu();
                                                        case 3:
                                                                gestor.mostrarProductePerCodi();
                                                        case 4:
                                                                gestor.mostrarProducte();
                                                        case 5:
                                                                fiSubmenuProductes = true;
                                                }
                                        }
                                }
                                case 4:
                                        gestor.afegirClient();
                                case 5:
                                        gestor.esborrarClient();
                                case 6:
                                        gestor.mostrarClient();
                                case 7:
                                        gestor.afegirTreballador();
                                case 8:
                                        gestor.esborrarTreballador();
                                case 9:
                                        gestor.mostrarTreballador();
                                {
                                        while (!fiSubmenuTreballador) {
                                                System.out.println(
                                                        "1- Filtar per nom" + "\n" +
                                                                "2- Filtrar per cognom" + "\n" +
                                                                "3- Filtrar per DNI" + "\n" +
                                                                "4- Filtrar per categoria" + "\n" +
                                                                "5- Sense filtrat" + "\n" +
                                                                "0- Sortir"
                                                );
                                                System.out.println("tria opció:");
                                                int opcioSubmenuProducte = in.nextInt();
                                                switch (opcioSubmenuProducte) {
                                                        case 1:
                                                                gestor.mostrarTreballadorPerNom();
                                                        case 2:
                                                                gestor.mostrarTreballadorCognom();
                                                        case 3:
                                                                gestor.mostrarTreballadorPerDni();
                                                        case 4:
                                                                gestor.mostrarTreballadorPerCategoria();
                                                        case 5:
                                                                gestor.mostrarProducte();
                                                        case 0:
                                                                fiSubmenuTreballador = true;
                                                }
                                        }
                                }
                                case 0:
                                        fimenu = true;
                        }
                }
        }
}




