package UF4;
import UF4.model.Producte;
import UF4.model.Treballador;
import UF4.model.clients;
import com.mysql.cj.xdevapi.Client;

import java.sql.SQLException;
import java.util.Scanner;

public class GestorDades {
    Scanner in =  new Scanner(System.in);
    public void afegirClient () throws SQLException {
        Interficie.mostrarMissatge("Dni: ");String nom = in.nextLine();
        Interficie.mostrarMissatge("Nom: ");String cognom = in.nextLine();
        Interficie.mostrarMissatge("Cognom");String dni = in.nextLine();
        Interficie.mostrarMissatge("Client Vip?: ");boolean clientVip = in.nextBoolean();
        clients s = new clients(nom,cognom,dni,clientVip);
        s.afegirClientBD();
    }
    public void esborrarClient () throws SQLException {
        clients s = new clients(in.nextLine(),in.nextLine(),in.nextLine());
        s.borrarClient();
    }
    public void mostrarClient () throws SQLException{
        clients s = new clients();
        s.mostrarClientBD();
    }

    public void afegirProducte () throws SQLException {
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
        Producte p = new Producte();
        Interficie.mostrarMissatge("nom per filtrar:");
        p.mostrarProductaFiltratPerNom(in.next());
    }

    public void mostrarProductePerPreu () throws SQLException{
        Producte p = new Producte();
        Interficie.mostrarMissatge("preu per filtrar:");
        p.mostrarProductaFiltratPerPreu(in.nextFloat());
    }

    public void mostrarProductePerCodi () throws SQLException{
        Producte p = new Producte();
        Interficie.mostrarMissatge("codi per filtrar:");
        p.mostrarProductaFiltratPerCodi(in.next());
    }

    public void afegirTreballador() throws SQLException {
        Treballador nou = new Treballador(in.nextLine(), in.nextLine(), in.nextLine(), in.nextInt());
        nou.afegirTreballadorBD();
    }
    public void esborrarTreballador() throws SQLException {
        Treballador esborrar = new Treballador(in.nextLine(),in.nextLine(),in.nextLine(),in.nextInt());
        esborrar.esborrarTreballadorBD();

    }
    public void mostrarTreballador() throws SQLException {
        Treballador mostrar = new Treballador();
        mostrar.mostrarTreballadorBD();

    }

    public void mostrarClientPerNom () throws SQLException {
        Interficie.mostrarMissatge("Introdueix el nom i el dni");
        String nomClient = in.nextLine();
        String dniclient = in.nextLine();

        clients mostrarNom = new clients();
        mostrarNom.mostrarClientPerNomBD(nomClient,dniclient);

    }

    public void mostrarClientsPerVip () throws SQLException {
        clients mostrarClientsVips = new clients();
        mostrarClientsVips.mostrarClientsVipBD();
    }

}
