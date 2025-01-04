package museum_management_system.Storage.Model;

import java.time.LocalDateTime;

public class Prestito {



    private LocalDateTime data_inizio;
    private LocalDateTime data_fine;
    private int cm_mostra;
    private int co_opera;


    public Prestito(LocalDateTime data_inizio, LocalDateTime data_fine, int cm_mostra, int co_opera) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.cm_mostra = cm_mostra;
        this.co_opera = co_opera;
    }


    public Prestito() {
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

    public int getCm_mostra() {
        return cm_mostra;
    }

    public void setCm_mostra(int cm_mostra) {
        this.cm_mostra = cm_mostra;
    }

    public int getCo_opera() {
        return co_opera;
    }

    public void setCo_opera(int co_opera) {
        this.co_opera = co_opera;
    }
}
