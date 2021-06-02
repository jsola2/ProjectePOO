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

}
