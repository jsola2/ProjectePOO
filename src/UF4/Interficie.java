package UF4;

/**
 *Aquesta classe és l'encarregada de mostrar tots els missatges perquè l'experiència d'usuari sigui bona. També estan les opcions del nostre menú i sub menú.
 */
public class Interficie {
    public  Interficie(){ }
    /**
     * Aquesta funció serveix per mostrar tots els missatges que és passa per paràmetre.
     *
     * @param missatge passem el misstatge per parametre
     */
    public void mostrarMissatge(String missatge) {
        System.out.printf("%-15s\n",missatge);
    }

    /**
     * Aquesta funció serveix per mostrar la part principal del menú
     * ok
     */
    public void mostrarMenu() {
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
    }

    /**
     * Aquesta funció serveix per mostrar el menú de productes.
     */
    public void mostarSubMenuProductes() {
        System.out.println(
                "1- Filtar per nom" + "\n" +
                        "2- Filtrar per preu" + "\n" +
                        "3- Filtrar per codi" + "\n" +
                        "4- Filtrar per marca" + "\n" +
                        "5- Filtrar per descripció" + "\n" +
                        "6- Sense filtrat" + "\n" +
                        "0- Sortir"
        );
    }

    /**
     * Aquesta funció serveix per mostrar el menú de Clients.
     */
    public void mostarSubMenuClients() {
        System.out.println(

                "1- Filtar per nom i dni" + "\n" +
                        "2- Mostrar nomes clients Vip" + "\n" +
                        "3- Sense filtrat" + "\n" +
                        "0- Sortir"
        );
    }

    /**
     * Aquesta funció serveix per mostrar el menú d'Empleats.
     */
     public void mostarSubMenuEmpleats() {
        System.out.println(
                "1- Filtar per nom" + "\n" +
                        "2- Filtrar per cognom" + "\n" +
                        "3- Filtrar per DNI" + "\n" +
                        "4- Filtrar per categoria" + "\n" +
                        "5- Filtrar per població" + "\n" +
                        "6- Filtrar per adreça" + "\n" +
                        "7- Sense filtrat" + "\n" +
                        "0- Sortir"
        );
    }

}

