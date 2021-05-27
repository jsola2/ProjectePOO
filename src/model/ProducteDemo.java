package model;

import java.util.ArrayList;
import java.util.Scanner;

class Producte {
    private String nom;
    private Float preu;
    private String codi;


    public Producte(String Nom, float Preu, String Codi) {
        this.nom = Nom;
        this.preu = Preu;
        this.codi = Codi;

    }

    public String getNom() {
        return nom;
    }

    public Float getPreu() {
        return preu;
    }

    public String getCodi() {
        return codi;
    }
}
class LlistaProductes{
    private ArrayList<Producte> llistaProductes;

    public LlistaProductes (){
        llistaProductes = new ArrayList<Producte>();
    }

    public void eliminarProducte (String pNom){
        int pos = 0;
        for (int i = 0;i<llistaProductes.size();i++) {
            if (llistaProductes.get(i).getNom().equals(pNom)){
                pos = i;
            }
        }
        this.llistaProductes.remove(pos);
    }
}
public class ProducteDemo{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String respostaAgregar = in.next();
        LlistaProductes llista = new LlistaProductes();
        System.out.println("Vols agregar un producte?(si/no)");
        if (respostaAgregar.equals("si") ){
            Producte producte = new Producte(in.next(),in.nextInt(),in.next());
        }else if (respostaAgregar.equals("no") ){
            System.out.println("Voldries eliminar un producte?(si/no)");
            String respostaEliminar = in.next();
            if (respostaEliminar.equals("si")){
                System.out.println("Digues el nom del producte que vols eliminar");
                String nom = in.next();
                llista.eliminarProducte(nom);
            }else if (respostaEliminar.equals("no")){
                System.out.println("Voldria modificar cap producte? (si/no)");
            }
        }else {
            System.out.println("No es una resposta valida");
        }
    }
}
