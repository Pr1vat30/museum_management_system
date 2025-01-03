package museum_management_system.Storage.Model;

public class Personale {

    private String cf;
    private String cognome;
    private String nome;
    private String password;
    private String tipo;
    private float stipendio;
    private String cf_admin;


    public Personale(String cf, String cognome, String nome, String password , String tipo , float stipendio , String cf_admin) {
        this.cf = cf;
        this.cognome = cognome;
        this.nome = nome;
        this.password = password;
        this.cf_admin = cf_admin;
        this.tipo = tipo;
        this.stipendio = stipendio;
    }


    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getStipendio() {
        return stipendio;
    }

    public void setStipendio(float stipendio) {
        this.stipendio = stipendio;
    }

    public String getCf_admin() {
        return cf_admin;
    }

    public void setCf_admin(String cf_admin) {
        this.cf_admin = cf_admin;
    }
}
