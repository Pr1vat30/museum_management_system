package museum_management_system.Application.Service;

import museum_management_system.Application.Dto.UserDTO;

import java.util.regex.Pattern;

public class RegistrazioneService {

    public static boolean saveUser(UserDTO userDTO) {
        //VERIFICA DEI DATI
        if(validaDatiUtente(userDTO)) {
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

    public static boolean updateUser(UserDTO userDTO, UserDTO newUserDTO) {
        return true;
    }
    public static boolean deleteUser(UserDTO userDTO) {
        return true;
    }

    public static boolean validaDatiUtente(UserDTO userDTO) {
        // Verifica che nome e cognome non siano vuoti
        if (userDTO.getNome() == null || userDTO.getNome().trim().isEmpty()) {
            return false;
        }

        if (userDTO.getCognome() == null || userDTO.getCognome().trim().isEmpty()) {
            return false;
        }

        // Verifica che l'email sia valida
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            return false;
        }

        // Verifica che il numero di telefono sia valido
        return userDTO.getTelefono() != null && !userDTO.getTelefono().trim().isEmpty();// Tutti i dati sono validi
    }


}
