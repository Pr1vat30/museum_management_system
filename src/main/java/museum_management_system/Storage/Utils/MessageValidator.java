package museum_management_system.Storage.Utils;

import museum_management_system.Storage.Model.Message;

public class MessageValidator {

    public static void validateMessage(Message message) {
        validateTitolo(message.getTitle());
        validateObject(message.getObject());
        validateContent(message.getContent());
    }

    public static void validateTitolo(String titolo) {
        if(titolo == null || titolo.length() < 3 || titolo.length() > 50) {
            throw new IllegalArgumentException("Titolo non valido o troppo lungo");
        }
    }

    public static void validateObject(String object) {
        if(object == null || object.length() < 3 || object.length() > 50) {
            throw new IllegalArgumentException("Oggetto non valido o troppo lungo");
        }
    }

    public static void validateContent(String content) {
        int aria = content.length();
        if(content == null || content.length() > 1000){
            throw new IllegalArgumentException("Contenuto troppo lungo");
        }
    }
}
