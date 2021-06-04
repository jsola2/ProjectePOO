package UF4;
import UF4.model.Producte;
import UF4.model.Treballador;
import UF4.model.Clients;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * En aquesta classe tenim totes les funcions que gestionen el funcionament del programa i també el gestionen les modificacions de les dades realitzades per l'usuari.
 */
public class GestorDades {
    Interficie Interficie = new Interficie();

    /**
     * Declarem el Scanner aqui perqué no hi hagi tant de codi repetit
     */
    Scanner in =  new Scanner(System.in);

    /**
     * En la funció afegirClient() podem veure que demanem la informació a l'usuari per després construir un objecte Client on
     * gràcies a la funció afegirClientBD() podem afegir el nou objecte client a la base de dades.
     */
    public void afegirClient () throws SQLException {
        Interficie.mostrarMissatge("Nom: ");
        String nom = in.nextLine();
        Interficie.mostrarMissatge("Cognom");
        String cognom = in.nextLine();
        Interficie.mostrarMissatge("Dni: ");
        String dni = in.nextLine();
        Interficie.mostrarMissatge("Poblacio: ");
        String poblacio = in.nextLine();
        Interficie.mostrarMissatge("Adreça: ");
        String adreca = in.nextLine();
        Interficie.mostrarMissatge("Client Vip?: ");
        boolean clientVip = in.nextBoolean();
        in.nextLine();
        Clients newClient = new Clients(nom,cognom,dni,poblacio,adreca,clientVip);
        newClient.afegirClientBD();
    }

    /**
     *En la funció esborrarClient() podem veure que demanem la informació a l'usuari per després construir un objecte Client on gràcies a la funció borrarClient() podem borrar el objecte client a la base de dades.
     */
    public void esborrarClient () throws SQLException {
        Interficie.mostrarMissatge("Nom: ");
        String nom = in.nextLine();
        Interficie.mostrarMissatge("Cognom: ");
        String cognom = in.nextLine();
        Interficie.mostrarMissatge("DNI: ");
        String dni = in.nextLine();

        Clients newClient = new Clients(nom,cognom,dni);
        newClient.borrarClient();
    }

    /**
     *En la funció mostrarClient() podem veure que no demanem la informació a l'usuari per i que directament mostra la informació de la taula client gràcies a la funció mostrarClientBD().
     */
    public void mostrarClient () throws SQLException{
        Clients newClient = new Clients();
        newClient.mostrarClientBD();
    }

    /**
     *En la funcióafegirProducte() podem veure que demanem la informació a l'usuari per després construir un objecteProducte on gràcies a la funcióafegirProducteBD() podem afegir el nou objecte Producte a la base de dades.
     */
    public void afegirProducte () throws SQLException {
        Interficie.mostrarMissatge("Nom: ");
        String nom = in.nextLine();
        Interficie.mostrarMissatge("preu: ");
        float preu= in.nextFloat();
        Interficie.mostrarMissatge("codi: ");
        String codi = in.next();
        Interficie.mostrarMissatge("Marca: ");
        String marca = in.next();
        Interficie.mostrarMissatge("Descripció: ");
        in.nextLine();
        String descripcio= in.nextLine();
        Producte p = new Producte(nom,preu,codi,marca,descripcio);
        p.afegirProducteBD();
    }

    /**
     * En la funció esborrarProducte() podem veure que demanem la informació a l'usuari per després construir un objecte Producteon gràcies a la funció borrarProducte() podem borrar el objecte Producte a la base de dades.
     */
    public void esborrarProducte () throws SQLException {
        Scanner in = new Scanner(System.in);
        Interficie.mostrarMissatge("codi: ");
        String codi = in.next();
        Producte p = new Producte(codi);
        p.borrarProducte();
    }

    /**
     *En la funció mostrarProducte() podem veure que no demanem la informació a l'usuari perque directament mostra la informació de la taula Producte gràcies a la funció mostrarProducteBD().
     */
    public void mostrarProducte () throws SQLException{
        Producte p = new Producte();
        p.mostrarProducteBD();
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarProducte() però amb la diferència de què aquesta funció filtra els productes pel nom.
     */
    public void mostrarProductePerNom () throws SQLException{
        Producte p = new Producte();
        Interficie.mostrarMissatge("nom per filtrar:");
        p.mostrarProductaFiltratPerNom(in.next());
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarProducte() però amb la diferència de què aquesta funció filtra els productes pel preu.
     * @throws SQLException
     */
    public void mostrarProductePerPreu () throws SQLException{
        Producte p = new Producte();
        Interficie.mostrarMissatge("preu per filtrar:");
        p.mostrarProductaFiltratPerPreu(in.nextFloat());
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarProducte() però amb la diferència de què aquesta funció filtra els productes pel codi.
     */
    public void mostrarProductePerCodi () throws SQLException{
        Producte p = new Producte();
        Interficie.mostrarMissatge("codi per filtrar:");
        p.mostrarProductaFiltratPerCodi(in.next());
    }

    /**
     *En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarProducte() però amb la diferència de què aquesta funció filtra els productes per la marca.
     */
    public void mostrarProductePerMarca() throws SQLException{
        Producte p = new Producte();
        Interficie.mostrarMissatge("marca per filtrar:");
        p.mostrarProductaFiltratPerMarca(in.next());
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarProducte() però amb la diferència de què aquesta funció filtra els productes per la descripció.
     */
    public void mostrarProductePerDescripcio() throws SQLException{
        Producte p = new Producte();
        Interficie.mostrarMissatge("descripció per filtrar:");
        p.mostrarProductaFiltratPerDescripcio(in.next());
    }

    /**
     * En la funció afegirTreballador() podem veure que demanem la informació a l'usuari per després construir un objecte Treballador on gràcies a la afegirTreballadorBD() podem afegir el nou objecte Treballador a la base de dades.
     */
    public void afegirTreballador() throws SQLException {
        Interficie.mostrarMissatge("Nom: ");
        String nom = in.nextLine();
        Interficie.mostrarMissatge("Cognom: ");
        String cognom = in.nextLine();
        Interficie.mostrarMissatge("DNI: ");
        String dni = in.nextLine();
        Interficie.mostrarMissatge("Poblacio: ");
        String poblacio = in.nextLine();
        Interficie.mostrarMissatge("Adreça: ");
        String adreca = in.nextLine();
        Interficie.mostrarMissatge("Categoria: ");
        int categoria = in.nextInt();
        Treballador nou = new Treballador(nom, cognom, dni, poblacio, adreca, categoria);
        nou.afegirTreballadorBD();
    }

    /**
     * En la funció esborrarTraballador() podem veure que demanem la informació a l'usuari per després construir un objecteTreballador gràcies a la funció esborrarTreballador() podem esborrar l'objecte Treballador a la base de dades.
     */
    public void esborrarTreballador() throws SQLException {
        Interficie.mostrarMissatge("DNI: ");
        String dni = in.nextLine();
        Treballador esborrar = new Treballador(dni);
        esborrar.esborrarTreballadorBD();
    }

    /**
     *En la funció mostrarTreballador() podem veure que no demanem la informació a l'usuari perquè directament mostra la informació de la taula Treballador gràcies a la funció mostrarTreballadorBD().
     */
    public void mostrarTreballador() throws SQLException {
        Treballador mostrar = new Treballador();
        mostrar.mostrarTreballadorBD();

    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarTreballador() però amb la diferència de què aquesta funció filtra els treballadors per el nom .
     */
    public void mostrarTreballadorPerNom () throws SQLException{
        Scanner in = new Scanner(System.in);
        Treballador t = new Treballador();
        Interficie.mostrarMissatge("nom per filtrar:");
        t.mostrarTreballadorPerNom(in.next());
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarTreballador() però amb la diferència de què aquesta funció filtra els treballadors per el cognom .
     */
    public void mostrarTreballadorCognom () throws SQLException{
        Treballador t = new Treballador();
        Interficie.mostrarMissatge("cognom per filtrar:");
        t.mostrarTreballadorCognom(in.next());
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarTreballador() però amb la diferència de què aquesta funció filtra els treballadors per el dni .
     */
    public void mostrarTreballadorPerDni () throws SQLException{
        Treballador t = new Treballador();
        Interficie.mostrarMissatge("dni per filtrar:");
        t.mostrarTreballadorPerDni(in.next());
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarTreballador() però amb la diferència de què aquesta funció filtra els treballadors per categora .
     */
    public void mostrarTreballadorPerCategoria () throws SQLException{
        Treballador t = new Treballador();
        Interficie.mostrarMissatge("categoria per filtrar:");
        t.mostrarTreballadorPerCategoria(in.next());
    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarClient() però amb la diferència de què aquesta funció filtra els clients per el nom i cognom.
     */
    public void mostrarClientPerNom () throws SQLException {
        Interficie.mostrarMissatge("Introdueix el nom i el dni");
        String nomClient = in.nextLine();
        String dniclient = in.nextLine();

        Clients mostrarNom = new Clients();
        mostrarNom.mostrarClientPerNomDniBD(nomClient,dniclient);

    }

    /**
     * En aquesta funció podem veure que té gairebé la mateixa funcionalitat que la funció mostrarClient() però amb la diferència de què aquesta funció filtra els clients per el Client Vip .
     */
    public void mostrarClientsPerVip () throws SQLException {
        Clients mostrarClientsVips = new Clients();
        mostrarClientsVips.mostrarClientsVipBD();
    }

}
