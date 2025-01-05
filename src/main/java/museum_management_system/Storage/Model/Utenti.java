package museum_management_system.Storage.Model;

public class Utenti {


    private String email ;
    private String nome;
    private String cognome;
    private String password;
    private int n_telefono;

    public Utenti(String email, String nome, String cognome, String password, int n_telefono) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.n_telefono = n_telefono;
    }

    public Utenti() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getN_telefono() {
        return n_telefono;
    }

    public void setN_telefono(int n_telefono) {
        this.n_telefono = n_telefono;
    }
}
