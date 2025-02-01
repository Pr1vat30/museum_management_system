package museum_management_system.Application.Service;
import jakarta.servlet.http.Part;
import museum_management_system.Storage.Dao.ArtsDao;
import museum_management_system.Storage.Model.Art;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class ArtsService implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "uploads";

    public List<Art> save(String baseUploadPath, Map<String, String> parameters, Part filePart) throws IOException {
        // Crea l'oggetto Art con i parametri forniti
        Art art = new Art(
                parameters.get("name"),
                parameters.get("desc"),
                parameters.get("artist"),
                parameters.get("length"),
                parameters.get("height")
        );
        ArtsDao artDao = new ArtsDao();

        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // Valida il formato del file
            if (isValidImageFile(fileName)) {
                throw new IOException("Formato file non valido. Sono permessi solo file JPG, PNG e GIF.");
            }

            // Genera un nome file unico
            String fileExtension = getFileExtension(fileName);
            String baseFileName = fileName.substring(0, fileName.lastIndexOf('.'));
            String destination = UPLOAD_DIRECTORY +  File.separator + baseFileName + "." + fileExtension;
            Path destinationPath = Paths.get(baseUploadPath, destination);

            for (int i = 2; Files.exists(destinationPath); i++) {
                destination = UPLOAD_DIRECTORY + File.separator + baseFileName + "_" + i + "." + fileExtension;
                destinationPath = Paths.get(baseUploadPath, destination);
            }

            // Crea la directory di upload se non esiste
            Files.createDirectories(destinationPath.getParent());

            try (InputStream fileInputStream = filePart.getInputStream()) {
                // Scrivi il file nella destinazione
                Files.copy(fileInputStream, destinationPath);
            }

            // Aggiungi il percorso del file all'oggetto Art
            art.setImage(destination);
        } else {
            throw new IOException("File immagine mancante.");
        }

        // Salva l'oggetto Art nel database
        artDao.InsertArt(art);
        return artDao.GetArts();
    }

    public List<Art> update(String baseUploadPath, Map<String, String> parameters, Part filePart) throws IOException {
        // Crea l'oggetto Art con i parametri forniti
        Art art = new Art(
                parameters.get("name"),
                parameters.get("desc"),
                parameters.get("artist"),
                parameters.get("length"),
                parameters.get("height")
        );
        art.setArt_id(Integer.parseInt(parameters.get("id")));
        ArtsDao artDao = new ArtsDao();

        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // Valida il formato del file
            if (isValidImageFile(fileName)) {
                throw new IOException("Formato file non valido. Sono permessi solo file JPG, PNG e GIF.");
            }

            // Genera un nome file unico
            String fileExtension = getFileExtension(fileName);
            String baseFileName = fileName.substring(0, fileName.lastIndexOf('.'));
            String destination = UPLOAD_DIRECTORY +  File.separator + baseFileName + "." + fileExtension;
            Path destinationPath = Paths.get(baseUploadPath, destination);

            for (int i = 2; Files.exists(destinationPath); i++) {
                destination = UPLOAD_DIRECTORY + File.separator + baseFileName + "_" + i + "." + fileExtension;
                destinationPath = Paths.get(baseUploadPath, destination);
            }

            // Crea la directory di upload se non esiste
            Files.createDirectories(destinationPath.getParent());

            try (InputStream fileInputStream = filePart.getInputStream()) {
                // Scrivi il file nella destinazione
                Files.copy(fileInputStream, destinationPath);
            }

            // Aggiungi il percorso del file all'oggetto Art
            art.setImage(destination);
        } else {
            throw new IOException("File immagine mancante.");
        }

        // Aggiorna l'oggetto Art nel database
        artDao.UpdateArt(art);
        return artDao.GetArts();
    }

    public List<Art> delete(int art_id) {
        ArtsDao artsDao = new ArtsDao();
        artsDao.DeleteArt(art_id);
        return artsDao.GetArts();
    }

    public List<Art> get() {
        ArtsDao artsDao = new ArtsDao();
        return artsDao.GetArts();
    }

    /* ------------------- utility ------------------------- */

    private boolean isValidImageFile(String fileName) {
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif"};
        String fileExtension = getFileExtension(fileName).toLowerCase();
        return !Arrays.asList(allowedExtensions).contains(fileExtension);
    }

    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        return (lastIndex == -1) ? "" : fileName.substring(lastIndex);
    }
}
