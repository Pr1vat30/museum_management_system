package museum_management_system.Storage.Model;

public class Telefono {

    private String cf_personale;
    private int numero;

    public Telefono(String cf_personale , int numero){
        this.cf_personale = cf_personale;
        this.numero = numero;
    }
    public Telefono(){

    }


    public String getCf_personale() {
        return cf_personale;
    }

    public void setCf_personale(String cf_personale) {
        this.cf_personale = cf_personale;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
