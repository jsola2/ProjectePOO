package model;

import java.util.ArrayList;
import java.util.Scanner;

public class LlistaClients {
    private ArrayList<Clients> llista;



    public LlistaClients(ArrayList<Clients> llista) {
        this.llista = llista;
    }

    public void afegirClient() {
        Scanner in = new Scanner(System.in);
        String nom = in.next();
        String cogomns = in.next();
        String dni = in.next();
        boolean clientVip = in.nextBoolean();

        Clients client = new Clients(in.next(),in.next(),in.next(),in.nextBoolean());

        int pos = 0;
        boolean dniIgual = false;

        for (int i = 0; i< llista.size(); i++) {
            if (llista.get(i).getDni().equals(dni)){
                pos = i;
                dniIgual = true;
            }
        }

        if (dniIgual){
            System.out.println("El client ja esta a la base de dates");
        }
        else {
            llista.add(client);
        }
    }

    public void eliminarClient(String pDni){
        int pos = 0;
        boolean dniIgual = false;
        for (int i = 0; i< llista.size(); i++) {
            if (llista.get(i).getDni().equals(pDni)){
                pos = i;
                dniIgual = true;
            }
        }
        if (dniIgual) {
            this.llista.remove(pos);
        }
        else{
            System.out.println("El client no esta a la base de dates");
        }
    }

}
