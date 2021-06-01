package UF4;
import UF4.model.Producte;
import UF4.model.Treballador;
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
        Producte p = new Producte(in.next(), in.nextFloat(), in.next());
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
    public void afegirTreballador() throws SQLException {

        Scanner in = new Scanner(System.in);
        Treballador nou = new Treballador(in.nextLine(), in.nextLine(), in.nextLine(), in.nextInt());
        nou.afegirTreballadorBD();
    }
    public void esborrarTreballador() throws SQLException {

        Scanner in = new Scanner(System.in);
        Treballador esborrar = new Treballador(in.nextLine(),in.nextLine(),in.nextLine(),in.nextInt());
        esborrar.esborrarTreballadorBD();

    }
    public void mostrarTreballador() throws SQLException {

        Treballador mostrar = new Treballador();
        mostrar.mostrarTreballadorBD();

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
