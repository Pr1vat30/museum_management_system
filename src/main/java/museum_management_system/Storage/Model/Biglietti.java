package museum_management_system.Storage.Model;

public class Biglietti {


    private String tipo;
    private float prezzo;
    private int cm_mostra;

    public Biglietti(String tipo, float prezzo, int cm_mostra) {
        this.tipo = tipo;
        this.prezzo = prezzo;
        this.cm_mostra = cm_mostra;
    }


    public Biglietti() {
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getCm_mostra() {
        return cm_mostra;
    }

    public void setCm_mostra(int cm_mostra) {
        this.cm_mostra = cm_mostra;
    }
}
