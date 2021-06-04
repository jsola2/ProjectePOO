package UF4;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *En aquesta classe Gestionem el menú principal.
 * També gestionem els sub menús de clients, productes i treballadors
 */
public class ProjectePOO {

    /**
     *En el main tenim les opcions del menú amb cada una de les opcions que gestionen el correcte funcionament del programa.
     */
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);

        GestorDades gestor = new GestorDades();
        boolean fimenu = false;

        while (!fimenu) {
            boolean fiSubmenuProductes = false;
            boolean fiSubmenuTreballador = false;
            boolean fiSubmenuClient = false;
            Interficie.mostrarMissatge("Benvingut al sistema gestor BRJ©");
            Interficie.mostrarMissatge("Escull una opcio: ");
            Interficie.mostrarMenu();
            Interficie.mostrarMissatge("Tria una opció:");
            int opcio = in.nextInt();
            switch (opcio) {
                case 1: gestor.afegirProducte();break;
                case 2: gestor.esborrarProducte();break;
                case 3: while (!fiSubmenuProductes) {
                        Interficie.mostarSubMenuProductes();
                        Interficie.mostrarMissatge("Tria una opció:");
                        int opcioSubmenuProducte = in.nextInt();
                        switch (opcioSubmenuProducte) {
                            case 1: gestor.mostrarProductePerNom();break;
                            case 2: gestor.mostrarProductePerPreu();break;
                            case 3: gestor.mostrarProductePerCodi();break;
                            case 4: gestor.mostrarProductePerMarca();break;
                            case 5: gestor.mostrarProductePerDescripcio();break;
                            case 6: gestor.mostrarProducte();break;
                            case 0: fiSubmenuProductes = true; break;
                        }
                    }break;
                case 4: gestor.afegirClient();break;
                case 5: gestor.esborrarClient();break;
                case 6: while (!fiSubmenuClient){
                        Interficie.mostarSubMenuClients();
                        int opcioSubmenuClient = in.nextInt();
                        switch (opcioSubmenuClient){
                            case 1: gestor.mostrarClientPerNom(); break;
                            case 2: gestor.mostrarClientsPerVip(); break;
                            case 3: gestor.mostrarClient(); break;
                            case 0: fiSubmenuClient = true; break;
                        }
                    }break;
                case 7: gestor.afegirTreballador();break;
                case 8: gestor.esborrarTreballador();break;
                case 9: while (!fiSubmenuTreballador) {
                        Interficie.mostarSubMenuEmpleats();
                        Interficie.mostrarMissatge("Tria una opció:");
                        int opcioSubmenuTreballador = in.nextInt();
                        switch (opcioSubmenuTreballador) {
                            case 1: gestor.mostrarTreballadorPerNom();break;
                            case 2: gestor.mostrarTreballadorCognom();break;
                            case 3: gestor.mostrarTreballadorPerDni();break;
                            case 4: gestor.mostrarTreballadorPerCategoria();break;
                            case 5: gestor.mostrarTreballador();break;
                            case 0: fiSubmenuTreballador = true;
                        }
                    }break;
                case 0: fimenu = true;break;
            }
        }
    }
}




