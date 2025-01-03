package museum_management_system.Storage.Model;

import java.time.LocalDateTime;

public class Acquisto {


    private int n_biglietto;
    private LocalDateTime data_acquisto;
    private int cm_mostra;
    private String tipo;
    private String email_utente;
    private LocalDateTime data_visita;


    public Acquisto(int n_biglietto, LocalDateTime data_acquisto, int cm_mostra, String tipo, String email_utente, LocalDateTime data_visita) {
        this.n_biglietto = n_biglietto;
        this.data_acquisto = data_acquisto;
        this.cm_mostra = cm_mostra;
        this.tipo = tipo;
        this.email_utente = email_utente;
        this.data_visita = data_visita;
    }


    public int getN_biglietto() {
        return n_biglietto;
    }

    public void setN_biglietto(int n_biglietto) {
        this.n_biglietto = n_biglietto;
    }

    public LocalDateTime getData_acquisto() {
        return data_acquisto;
    }

    public void setData_acquisto(LocalDateTime data_acquisto) {
        this.data_acquisto = data_acquisto;
    }

    public int getCm_mostra() {
        return cm_mostra;
    }

    public void setCm_mostra(int cm_mostra) {
        this.cm_mostra = cm_mostra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail_utente() {
        return email_utente;
    }

    public void setEmail_utente(String email_utente) {
        this.email_utente = email_utente;
    }

    public LocalDateTime getData_visita() {
        return data_visita;
    }

    public void setData_visita(LocalDateTime data_visita) {
        this.data_visita = data_visita;
    }
}
