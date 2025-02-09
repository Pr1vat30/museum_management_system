package museum_management_system.Storage.Utils;

import jakarta.servlet.http.Part;
import museum_management_system.Storage.Model.Art;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ArtValidator {

    public static void validateArtName(String artName) {
        if (artName == null || artName.length() < 3 || artName.length() > 50 ||
                !Pattern.matches("^[a-zA-Z]+(?: [a-zA-Z]+)?$", artName)) {
            System.out.println(artName);
            throw new IllegalArgumentException("Il nome dell'opera deve essere maggiore di 3 caratteri, massimo 50 e contenere solo lettere");
        }
    }


    public static void validateArtDesc(String artDesc) {
        if (artDesc == null || artDesc.length() < 10 || artDesc.length() > 200) {
            throw new IllegalArgumentException("La descrizione dell'opera deve essere maggiore di 10 caratteri e massimo di 200");
        }
    }


    public static void validateArtArtist(String artArtist) {
        if (artArtist == null || artArtist.length() < 3 || artArtist.length() > 50 ||
                !Pattern.matches("^[a-zA-Z]+(?: [a-zA-Z]+)*$", artArtist)) {
            throw new IllegalArgumentException("Il nome dell'artista deve essere maggiore di 3 caratteri, massimo 50 e contenere solo lettere");
        }
    }


    public static void validateArtlenght(String artLenght) {
        if (artLenght == null || artLenght.length() >50 || !Pattern.matches("^\\d{1,50}$", artLenght)) {
            throw new IllegalArgumentException("Il valore della lunghezza dell'opera deve avere massimo 50 cifre e devono essere tutti valori numerici");
        }
    }


    public static void validateArtHeight(String artHeight) {
        if (artHeight == null || artHeight.length() >50 || !Pattern.matches("^\\d{1,50}$", artHeight)) {
            throw new IllegalArgumentException("Il valore dell'altezza dell'opera deve avere massimo 50 cifre e devono essere tutti valori numerici");
        }
    }



    private static final List<String> VALID_IMAGE_CONTENT_TYPES = Arrays.asList(
            "image/jpeg", "image/png", "image/gif", "image/bmp", "image/webp");

    public static void validateImage(Part filePart) throws IllegalArgumentException, IOException {
        if (filePart == null || filePart.getSize() == 0) {
            throw new IllegalArgumentException("Nessun file caricato.");
        }

        // Controlla il tipo di contenuto del file
        String contentType = filePart.getContentType();
        if (contentType == null || !VALID_IMAGE_CONTENT_TYPES.contains(contentType)) {
            throw new IllegalArgumentException("Il file non è un'immagine valida. Sono permessi solo JPG, PNG, GIF, BMP, WEBP.");
        }

        // Controlla se l'estensione del file è una delle estensioni valide
        String fileName = filePart.getSubmittedFileName();
        if (fileName != null && !isValidImageExtension(fileName)) {
            throw new IllegalArgumentException("Il file non ha un'estensione valida. Sono permessi solo JPG, PNG, GIF, BMP, WEBP.");
        }
    }

    // Verifica se l'estensione del file è una delle estensioni per le immagini valide
    private static boolean isValidImageExtension(String fileName) {
        String fileExtension = getFileExtension(fileName);
        return Arrays.asList("jpg", "jpeg", "png", "gif", "bmp", "webp").contains(fileExtension.toLowerCase());
    }

    // Estrai l'estensione del file
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return "";
        }
        return fileName.substring(dotIndex + 1);
    }


    //------------------------validazione dell'opera---------------------------//

    public static void validateArt(Art art , Part image) throws IOException {
        validateArtName(art.getName());
        validateArtDesc(art.getDesc());
        validateArtArtist(art.getArtist());
        validateArtlenght(art.getLength());
        validateArtHeight(art.getHeight());
        validateImage(image);
    }
}
