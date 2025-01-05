package museum_management_system.Storage.Model;

import java.time.LocalDateTime;

public class Avvisi {

    private String descrizione;
    private String titolo;
    private LocalDateTime data;

    public Avvisi(String descrizione, String titolo, LocalDateTime data) {
        this.descrizione = descrizione;
        this.titolo = titolo;
        this.data = data;
    }

    public Avvisi() {
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
