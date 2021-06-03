package UF4;

public class Interficie {
    public static void mostrarMissatge (String missatge){
        System.out.println(missatge);
    }

    public static void mostrarMenu(){
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

   public static void mostarSubMenuProductes(){
       System.out.println(
               "1- Filtar per nom" + "\n" +
                       "2- Filtrar per preu" + "\n" +
                       "3- Filtrar per codi" + "\n" +
                       "4- Sense filtrat" + "\n" +
                       "0- Sortir"
       );
   }

    public static void mostarSubMenuClients(){
        System.out.println(

                "1- Filtar per nom i dni" + "\n" +
                "2- Mostrar nomes clients Vip" + "\n" +
                "3- Sense filtrat" + "\n" +
                "0- Sortir"
        );
    }

    public static void mostarSubMenuEmpleats(){
        System.out.println(
                "1- Filtar per nom" + "\n" +
                        "2- Filtrar per cognom" + "\n" +
                        "3- Filtrar per DNI" + "\n" +
                        "4- Filtrar per categoria" + "\n" +
                        "5- Sense filtrat" + "\n" +
                        "0- Sortir"
        );
    }

    public static void DadesIntroduccioTreballador() {
        System.out.println(
                "Per favor, introdrueix el nom, el cognom, el DNI del treballador i el número " +
                        "de la seva categoria, pemi: " + "\n" +
                        "1 Per empleat/empleada de la neteja" + "\n" +
                        "2 Per empleat/empleada cambrer" + "\n" +
                        "3 Per empleat/empleada de bar"

        );
    }

    public static void EsborrarDadesTreballador (){
        System.out.println( "Per favor, introdrueix el DNI del treballador que vol esborrar: ");
    }

}

