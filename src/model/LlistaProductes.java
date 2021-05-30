package model;

import java.util.ArrayList;
import java.util.Scanner;

public class LlistaProductes{
    private ArrayList<Producte> llista;

    public LlistaProductes (){
        llista = new ArrayList<Producte>();
    }

    public void eliminarProducte (){
        Scanner in = new Scanner(System.in);
        String pNom = in.next();
        int pos = 0;
        for (int i = 0; i< llista.size(); i++) {
            if (llista.get(i).getNom().equals(pNom)){
                pos = i;
            }
        }
        this.llista.remove(pos);
    }

    public void agregarProducte (){
        Scanner in = new Scanner(System.in);
        Producte producte = new Producte(in.next(), in.nextFloat(), in.next());
        llista.add(producte);
    }


}
