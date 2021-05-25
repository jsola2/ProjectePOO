package model;

public class Treballador {

    private String nom;
    private String cognom;
    private String dni;
    private float salari;

    public Treballador(String nom, String cognom, String dni, tipusDempleat salari) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;

    }


}
enum tipusDempleat {


    NETEJA(1200f),
    CAMBRER(1500f),
    BARMAN(1600f);

    private final float salari;

    tipusDempleat(float salari) {
        this.salari = salari;
    }

    private float salariMax;


    public void generarEmpleat() {

        Treballador nom = new Treballador("Juan","Fernandez","48526314A",CAMBRER);

    }
}