package UF4;
import UF4.model.Producte;
import UF4.model.Treballador;
import UF4.model.Clients;

import java.sql.SQLException;
import java.util.Scanner;

public class GestorDades {
    Scanner in =  new Scanner(System.in);
    public void afegirClient () throws SQLException {
        Interficie.mostrarMissatge("Dni: ");
        String dni = in.nextLine();
        Interficie.mostrarMissatge("Nom: ");
        String nom = in.nextLine();
        Interficie.mostrarMissatge("Cognom");
        String cognom = in.nextLine();
        Interficie.mostrarMissatge("Client Vip?: ");
        boolean clientVip = in.nextBoolean();
        Clients s = new Clients(nom,cognom,dni,clientVip);
        s.afegirClientBD();
    }
    public void esborrarClient () throws SQLException {
        Interficie.mostrarMissatge("Nom: ");
        String nom = in.nextLine();
        Interficie.mostrarMissatge("Cognom: ");
        String cognom = in.nextLine();
        Interficie.mostrarMissatge("DNI: ");
        String dni = in.nextLine();
        Clients s = new Clients(in.nextLine(),in.nextLine(),in.nextLine());
        s.borrarClient();
    }
    public void mostrarClient () throws SQLException{
        Clients s = new Clients();
        s.mostrarClientBD();
    }

    public void afegirProducte () throws SQLException {
        Interficie.mostrarMissatge("Nom: ");
        String nom = in.nextLine();
        Interficie.mostrarMissatge("preu: ");
        float preu= in.nextFloat();
        Interficie.mostrarMissatge("codi: ");
        String codi = in.next();
        Producte p = new Producte(nom,preu,codi);
        p.afegirProducteBD();
    }
    public void esborrarProducte () throws SQLException {
        Scanner in = new Scanner(System.in);
        Interficie.mostrarMissatge("codi: ");
        String codi = in.next();
        Producte p = new Producte(codi);
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
    public void mostrarTreballadorPerNom () throws SQLException{
        Scanner in = new Scanner(System.in);
        Treballador t = new Treballador();
        System.out.println("nom per filtrar:");
        t.mostrarTreballadorPerNom(in.next());
    }

    public void mostrarTreballadorCognom () throws SQLException{
        Scanner in = new Scanner(System.in);
        Treballador t = new Treballador();
        System.out.println("cognom per filtrar:");
        t.mostrarTreballadorCognom(in.next());
    }

    public void mostrarTreballadorPerDni () throws SQLException{
        Scanner in = new Scanner(System.in);
        Treballador t = new Treballador();
        System.out.println("dni per filtrar:");
        t.mostrarTreballadorPerDni(in.next());
    }
    public void mostrarTreballadorPerCategoria () throws SQLException{
        Scanner in = new Scanner(System.in);
        Treballador t = new Treballador();
        System.out.println("categoria per filtrar:");
        t.mostrarTreballadorPerCategoria(in.next());
    }

    public void mostrarClientPerNom () throws SQLException {
        Interficie.mostrarMissatge("Introdueix el nom i el dni");
        String nomClient = in.nextLine();
        String dniclient = in.nextLine();

        Clients mostrarNom = new Clients();
        mostrarNom.mostrarClientPerNomBD(nomClient,dniclient);

    }

    public void mostrarClientsPerVip () throws SQLException {
        Clients mostrarClientsVips = new Clients();
        mostrarClientsVips.mostrarClientsVipBD();
    }

}
