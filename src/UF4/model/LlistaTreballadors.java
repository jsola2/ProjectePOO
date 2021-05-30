package UF4.model;

import java.util.ArrayList;
import java.util.Scanner;

public class LlistaTreballadors {
    private ArrayList<Treballador> treballadorNou;

public LlistaTreballadors(){

    treballadorNou = new ArrayList<>();
}
    public void afegirTreballador() {

        Scanner in = new Scanner(System.in);
        String nom = in.next();
        String cognom = in.next();
        String dni = in.next();
        int categoriaTipus = in.nextInt();
        Treballador nou = new Treballador(nom, cognom, dni, categoriaTipus);
        for (int i = 0; i < treballadorNou.size(); i++) {
                if (!treballadorNou.get(i).getDni().equals(dni)) {
                    treballadorNou.add(nou);
                } else {
                    System.out.println("Aquest treballador ja està creat");
                }
            }
        }


    public void esborrarTreballador() {

    Scanner dniEsborrar = new Scanner(System.in);

        for (int i = 0; i < treballadorNou.size(); i++) {
            if (treballadorNou.get(i).getDni().equals(dniEsborrar)){
                treballadorNou.remove(i);
            }else{
                System.out.println("Aquest treballador no es pot esborrar per que no existeix a la base de dades");
            }
        }
    }
}