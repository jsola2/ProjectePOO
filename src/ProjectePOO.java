import java.util.Scanner;

public class ProjectePOO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GestorDades gestor = new GestorDades();
        System.out.println("Benvingut al gestor del pub, seleccioni una opcio" + "\t" + "1- Carregar Dades" + "\t" +
                "2- Consultar" + "\t" + "3- Afegir" + "\t" + "4- Esborrar" + "\t" + "0- Sortir");
        int menu = in.nextInt();
        switch (menu){
           // case 1 : gestor.carregarDades();break;
          //  case 2 : gestor.consultar();break;
            case 3 : gestor.afegir();break;
           // case 4 : gestor.esborrar();break;
           // case 0 : gestor.sortir();break;
        }
    }


}
