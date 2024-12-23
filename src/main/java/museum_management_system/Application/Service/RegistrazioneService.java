package museum_management_system.Application.Service;

import museum_management_system.Storage.Model.User;

public class RegistrazioneService {

    public RegistrazioneService() {}

    public boolean saveUser(User user) {
        //VERIFICA DEI DATI
        if(validaDatiUtente(user)) {
            //SALVO I DATI DELL'UTENTE NEL DATABASE COME NUOVO UTENTE
            /*
            UserDAOImpl conn = new UserDAOImpl(DatabaseConnection.getConnection());
            conn.addUser(us);
            */
            //return true;    //SE VA A BUON FINE
            return false; //SE CI SONO PROBLEMI
        }
        return false;
    }

    public boolean updateUser(User user, User newUser) {
        return true;
    }
    public boolean deleteUser(User user) {
        return true;
    }

    public boolean validaDatiUtente(User user) {
        // Verifica che nome e cognome non siano vuoti
        if (user.getNome() == null || user.getNome().trim().isEmpty()) {
            return false;
        }

        if (user.getCognome() == null || user.getCognome().trim().isEmpty()) {
            return false;
        }

        // Verifica che l'email sia valida
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return false;
        }

        // Verifica che il numero di telefono sia valido
        if (user.getTelefono() == null || user.getTelefono().trim().isEmpty()) {
            return false;
        }
        return true;  // Tutti i dati sono validi
    }


}
