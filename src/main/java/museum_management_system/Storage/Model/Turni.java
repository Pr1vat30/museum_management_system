package museum_management_system.Storage.Model;

import java.time.LocalDateTime;

public class Turni {


    private String giorno ;
    private String impiegato;
    private LocalDateTime ora_inizio;
    private LocalDateTime ora_fine;


    public Turni(String giorno, String impiegato, LocalDateTime ora_inizio, LocalDateTime ora_fine) {
        this.giorno = giorno;
        this.impiegato = impiegato;
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
    }

    public Turni() {
    }


    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getImpiegato() {
        return impiegato;
    }

    public void setImpiegato(String impiegato) {
        this.impiegato = impiegato;
    }

    public LocalDateTime getOra_inizio() {
        return ora_inizio;
    }

    public void setOra_inizio(LocalDateTime ora_inizio) {
        this.ora_inizio = ora_inizio;
    }

    public LocalDateTime getOra_fine() {
        return ora_fine;
    }

    public void setOra_fine(LocalDateTime ora_fine) {
        this.ora_fine = ora_fine;
    }
}
