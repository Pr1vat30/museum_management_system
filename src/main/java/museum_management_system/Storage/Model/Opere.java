package museum_management_system.Storage.Model;

public class Opere {



    private int co;
    private String nome;
    private int lunghezza;
    private int altezza;
    private int larghezza;
    private String descrizione;

    public Opere(int co, String nome, int lunghezza, int altezza, int larghezza, String descrizione) {
        this.co = co;
        this.nome = nome;
        this.lunghezza = lunghezza;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.descrizione = descrizione;
    }


    public Opere() {
    }


    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
