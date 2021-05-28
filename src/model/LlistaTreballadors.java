package model;

import java.util.ArrayList;
import java.util.Scanner;

public class LlistaTreballadors {
    private ArrayList<Treballador> treballadorNou;
    private String nom;
    private String cognom;
    private String dni;
    private int categoria;
public LlistaTreballadors(){

    treballadorNou = new ArrayList<>();
}
    public void afegirTreballador() {

        Scanner in = new Scanner(System.in);
        String afegirNom = in.next();
        String afegirCognom = in.next();
        String afegirDni = in.next();
        int categoriaTipus = in.nextInt();
        Treballador nou = new Treballador(afegirNom, afegirCognom, afegirDni, categoriaTipus);
        for (int i = 0; i < treballadorNou.size(); i++) {
                if (!treballadorNou.get(i).getDni().equals(dni)) {
                    treballadorNou.add(nou);
                } else {

                }
            }
        }
    }

    public void esborrarTreballador() {

    Scanner seleccio = new Scanner(System.in);

        for (int i = 0; i < treballadorNou.size(); i++) {
            if (treballadorNou.get(i).equals(dni)){

            }
        }
    }
}