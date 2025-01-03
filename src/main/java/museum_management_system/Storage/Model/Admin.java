package museum_management_system.Storage.Model;

public class Admin {

    private String cf;
    private String cognome;
    private String nome;
    private String password;


    public Admin(String cf, String cognome, String nome, String password) {
        this.cf = cf;
        this.cognome = cognome;
        this.nome = nome;
        this.password = password;
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
}
