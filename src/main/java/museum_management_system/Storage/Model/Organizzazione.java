package museum_management_system.Storage.Model;

import java.time.LocalDateTime;

public class Organizzazione {


    private LocalDateTime data_organizzazione;
    private int cf_personale;
    private int cm;


    public Organizzazione(LocalDateTime data_organizzazione, int cf_personale, int cm) {
        this.data_organizzazione = data_organizzazione;
        this.cf_personale = cf_personale;
        this.cm = cm;
    }

    public Organizzazione() {
    }


    public LocalDateTime getData_organizzazione() {
        return data_organizzazione;
    }

    public void setData_organizzazione(LocalDateTime data_organizzazione) {
        this.data_organizzazione = data_organizzazione;
    }

    public int getCf_personale() {
        return cf_personale;
    }

    public void setCf_personale(int cf_personale) {
        this.cf_personale = cf_personale;
    }

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }
}
