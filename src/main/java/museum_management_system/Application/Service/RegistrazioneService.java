package museum_management_system.Application.Service;

import museum_management_system.Application.Dto.UserDTO;
import museum_management_system.Storage.Model.User;

public class RegistrazioneService {

    public static boolean saveUser(UserDTO userDTO) {
        try{
            validaDatiUtente(userDTO);
            UserDAO dd = new UserDAO();
            dd.saveUser(convertiInEntita(userDTO));
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updateUser(UserDTO newUserDTO) {
        return true;
    }
    public static boolean deleteUser(UserDTO userDTO) {
        return true;
    }

    public static void validaDatiUtente(UserDTO userDTO) {
        // Verifica che nome e cognome non siano vuoti
        if (userDTO.getNome() == null || userDTO.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome utente non valido");
        }

        if (userDTO.getCognome() == null || userDTO.getCognome().trim().isEmpty()) {
            throw new IllegalArgumentException("Cognome utente non valido");
        }
        UserDAO dd = new UserDAO();
        User us = dd.getUserByEmail(userDTO.getEmail());
        // Verifica che l'email sia valida
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty() || us != null) {
            throw new IllegalArgumentException("Email utente non valida o già utilizzata");
        }
    }

    private static UserDTO convertiInDTO(User us) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(us.getNome());
        userDTO.setCognome(us.getCognome());
        userDTO.setEmail(us.getEmail());
        userDTO.setTelefono(us.getTelefono());
        return userDTO;
    }

    private static User convertiInEntita(UserDTO userDTO) {
        User us = new User();
        us.setNome(userDTO.getNome());
        us.setCognome(userDTO.getCognome());
        us.setEmail(userDTO.getEmail());
        us.setPassword(userDTO.getPassword());
        us.setTelefono(userDTO.getTelefono());
        return us;

    }


}
