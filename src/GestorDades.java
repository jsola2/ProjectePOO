import model.LlistaTreballadors;
import model.Treballador;

import java.util.ArrayList;
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
              case 2 :
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
