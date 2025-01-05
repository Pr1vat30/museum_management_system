package museum_management_system.Storage.Model;

import java.time.LocalDateTime;

public class Mostre {

    private int cm;
    private LocalDateTime data_inizio;
    private LocalDateTime data_fine;
    private int n_posti;
    private int n_posti_disponibili;
    private String descrizione;
    private String nome;


    public Mostre(int cm, LocalDateTime data_inizio, LocalDateTime data_fine, int n_posti, int n_posti_disponibili, String descrizione, String nome) {
        this.cm = cm;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.n_posti = n_posti;
        this.n_posti_disponibili = n_posti_disponibili;
        this.descrizione = descrizione;
        this.nome = nome;
    }

    public Mostre() {
    }

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }

    public LocalDateTime getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(LocalDateTime data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDateTime getData_fine() {
        return data_fine;
    }

    public void setData_fine(LocalDateTime data_fine) {
        this.data_fine = data_fine;
    }

    public int getN_posti() {
        return n_posti;
    }

    public void setN_posti(int n_posti) {
        this.n_posti = n_posti;
    }

    public int getN_posti_disponibili() {
        return n_posti_disponibili;
    }

    public void setN_posti_disponibili(int n_posti_disponibili) {
        this.n_posti_disponibili = n_posti_disponibili;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
