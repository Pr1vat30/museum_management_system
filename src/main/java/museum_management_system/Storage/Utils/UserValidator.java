package museum_management_system.Storage.Utils;

import museum_management_system.Storage.Model.PayMethod;
import museum_management_system.Storage.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserValidator {

    // Lista simulata di utenti
    //public static List<User> userList = new ArrayList<>();

    // Validazione del nome utente
    public static void validateUserName(String userName) {
        if (userName == null || userName.length() < 3 || userName.length() > 50 ||
                !Pattern.matches("^[a-zA-Z]+(?: [a-zA-Z]+)?$", userName)) {
            throw new IllegalArgumentException("Il nome utente deve essere maggiore di 3 caratteri, massimo 50 e contenere solo lettere");
        }
    }

    // Validazione dell'email
    public static void validateEmail(String userEmail) {
        if (userEmail == null || userEmail.length() > 100 ||
                !Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", userEmail)) {
            throw new IllegalArgumentException("Formato email non valido o lunghezza superiore a 100 caratteri");
        }
    }

    // Validazione della password
    public static void validatePassword(String password) {
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("La password deve contenere almeno 6 caratteri");
        }
        if (!Pattern.matches(".*[0-9].*", password)) {
            throw new IllegalArgumentException("La password deve contenere almeno un numero");
        }
        if (!Pattern.matches(".*[\\p{Punct}].*", password)) {
            throw new IllegalArgumentException("La password deve contenere almeno un carattere speciale");
        }
    }

    // Validazione del numero di telefono
    public static void validatePhoneNumber(String phoneNumber) {
        String phoneRegex = "^([+]?[0-9]{1,4}[-. ]?)?([(]?[0-9]{1,3}[)]?[-. ]?)?([0-9]{1,4}[-. ]?){1,3}[0-9]{1,9}$";
        if (phoneNumber == null || phoneNumber.length() > 100 || !Pattern.matches(phoneRegex, phoneNumber)) {
            throw new IllegalArgumentException("Formato numero di telefono non valido o lunghezza superiore a 100 caratteri");
        }
    }

    // Validazione del numero della carta di credito
    public static void validateCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new IllegalArgumentException("Il numero della carta deve avere esattamente 16 cifre");
        }
    }

    // Validazione della data di scadenza della carta
    public static void validateCardExpiryDate(String expiryDate) {
        if (expiryDate == null || !Pattern.matches("^[0-9]{2}/[0-9]{2}$", expiryDate)) {
            throw new IllegalArgumentException("Formato data scadenza carta non valido");
        }
    }

    // Validazione del codice segreto della carta
    public static void validateCardSecretCode(String secretCode) {
        if (secretCode == null || secretCode.length() != 3 || !Pattern.matches("^[0-9]{3}$", secretCode)) {
            throw new IllegalArgumentException("Il codice segreto deve essere di 3 cifre");
        }
    }

    // Validazione dell'utente
    public static void validateUser(User user) {
        validateUserName(user.getName());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
        validatePhoneNumber(user.getPhone());

//        // Controllo se l'utente esiste già nella lista
//        if (isUserExists(user)) {
//            throw new IllegalArgumentException("L'utente con questa email esiste già");
//        }
        // Aggiungi l'utente alla lista se è valido
        //userList.add(user);
    }

    // Verifica se l'utente esiste già
//    private static boolean isUserExists(User user) {
//        return userList.stream().anyMatch(existingUser -> existingUser.getEmail().equals(user.getEmail()));
//    }

    // Validazione del metodo di pagamento
    public static void validatePaymentMethod(PayMethod payMethod) {
        validateCardNumber(payMethod.getCard_number());
        validateCardExpiryDate(payMethod.getCard_expiry_date());
        validateCardSecretCode(payMethod.getCard_secret_code());
    }
}