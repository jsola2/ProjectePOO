import model.LlistaProductes;

public class GestorDades {

    private LlistaProductes llista;
    public Object carregarDades;

    public Object getCarregarDades() {
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



}


