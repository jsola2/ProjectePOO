package UF4;
import UF4.model.Producte;
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

    public void afegirProducte () throws SQLException {
        Scanner in = new Scanner(System.in);
        Producte p = new Producte(in.next(),in.nextFloat(), in.next());
        p.afegirProducteBD();
    }
    public void esborrarProducte () throws SQLException {
        Scanner in = new Scanner(System.in);
        Producte p = new Producte(in.nextLine());
        p.borrarProducte();
    }
    public void mostrarProducte () throws SQLException{
        Producte p = new Producte();
        p.mostrarProducteBD();
    }

    public void mostrarProductePerNom () throws SQLException{
        Scanner in = new Scanner(System.in);
        Producte p = new Producte();
        System.out.println("nom per filtrar:");
        p.mostrarProductaFiltratPerNom(in.next());
    }

    public void mostrarProductePerPreu () throws SQLException{
        Scanner in = new Scanner(System.in);
        Producte p = new Producte();
        System.out.println("preu per filtrar:");
        p.mostrarProductaFiltratPerPreu(in.nextFloat());
    }

    public void mostrarProductePerCodi () throws SQLException{
        Scanner in = new Scanner(System.in);
        Producte p = new Producte();
        System.out.println("codi per filtrar:");
        p.mostrarProductaFiltratPerCodi(in.next());
    }

    /*
    public Object carregarDades ();


    public Object getCarregarDades() {
        return carregarDades;
    }

    public Object consultar;
    public void afegir () {

        Scanner in = new Scanner(System.in);
        int menuAfegir = in.nextInt();

        LlistaTreballadors a = new LlistaTreballadors();
        switch (menuAfegir){

            case 1 : a.afegirTreballador();break;
            case 2 : llista.afegirProducte();break;
            case 3 :
            case 0 :
        }
    }




    public void esborrar () {
        Scanner in = new Scanner(System.in);
        int menuEsborrar = in.nextInt();
        LlistaTreballadors e = new LlistaTreballadors();
        switch (menuEsborrar) {
            case 1:
                e.esborrarTreballador();
            case 2:
            case 3:
        }
    }
    public void sortir () {

        Scanner in = new Scanner(System.in);
        int seleccio = in.nextInt();
        if (seleccio == 0){

        }
    }
}

    private LlistaProductes llista;
    public String carregarDades;

    public String getCarregarDades() {
        return carregarDades;
    }

    public Object consultar;

    public void afegirProducte(){
        llista.agregarProducte();
    }

    public void esborrarProducte(String pNom){
        llista.eliminarProducte(pNom);
    }
    public Object sortir;
    */

}
