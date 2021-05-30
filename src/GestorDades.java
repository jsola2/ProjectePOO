import UF4.model.LlistaProductes;
import UF4.model.LlistaTreballadors;

import java.util.Scanner;


public class GestorDades {


    public Object carregarDades ();


    public Object getCarregarDades() {
        return carregarDades;
    }

    public Object consultar;
    public void afegir () {

         Scanner in = new Scanner(System.in);
         int menuAfegir = in.nextInt();

         LlistaTreballadors a = new LlistaTreballadors();
         switch (menuAfegir){

              case 1 : a.afegirTreballador();break;
              case 2 : llista.afegirProducte();break;
              case 3 :
              case 0 :
            }
        }




    public void esborrar () {
         Scanner in = new Scanner(System.in);
         int menuEsborrar = in.nextInt();
         LlistaTreballadors e = new LlistaTreballadors();
         switch (menuEsborrar) {
              case 1:
                   e.esborrarTreballador();
              case 2:
              case 3:
         }
    }
    public void sortir () {

          Scanner in = new Scanner(System.in);
          int seleccio = in.nextInt();
          if (seleccio == 0){

          }
         }
     }

    private LlistaProductes llista;
    public String carregarDades;

    public String getCarregarDades() {
        return carregarDades;
    }

    public Object consultar;

    public void afegirProducte(){
        llista.agregarProducte();
    }

    public void esborrarProducte(String pNom){
        llista.eliminarProducte(pNom);
    }
    public Object sortir;

