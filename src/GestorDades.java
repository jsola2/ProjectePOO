import model.LlistaClients;
import model.LlistaProductes;

public class GestorDades {

    private LlistaProductes llistaP;
    private LlistaClients   llistaC;
    public String carregarDades;

    public String getCarregarDades() {
        return carregarDades;
    }

    public Object consultar;

    public void afegirProducte(){
        llistaP.agregarProducte();
    }

    public void esborrarProducte(String pNom){
        llistaP.eliminarProducte();
    }

    public void afegirClient(){
        llistaP.agregarProducte();
    }

    public void esborrarClient(String pDni){
        llistaP.eliminarProducte();
    }

    public Object sortir;



}


