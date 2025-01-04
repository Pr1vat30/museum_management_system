package museum_management_system.Application.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import museum_management_system.Application.Dto.BigliettoDTO;
import museum_management_system.Storage.Dao.BigliettiDAO;
import museum_management_system.Storage.Model.Ticket;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestioneBigliettiService {
    public static boolean createBiglietto(BigliettoDTO bigliettoDTO) {
        try{
            validateBiglietto(bigliettoDTO);
            Ticket tk = convertiInEntita(bigliettoDTO);
            BigliettiDAO bb = new BigliettiDAO();
            bb.addTicket(tk);
            return true;
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return false;
        }

    }

    public static BigliettoDTO getBigliettobyID(int id){
        BigliettiDAO bb = new BigliettiDAO();
        Ticket tk = bb.getTicketById(id);
        BigliettoDTO biglietto = convertiInDTO(tk);
        generaQRcode(biglietto.getId());
        return biglietto;
    }

    public static List<BigliettoDTO> getAllBiglietti() {
        BigliettiDAO bb = new BigliettiDAO();
        List<Ticket> ttks = bb.getAllTickets();
        List<BigliettoDTO> listaBiglietti = new ArrayList<>();
        for (Ticket ttk : ttks){
            BigliettoDTO biglietto = convertiInDTO(ttk);
            generaQRcode(ttk.getId());
            listaBiglietti.add(biglietto);
        }
        return listaBiglietti;
    }

    public static void updateBiglietto(BigliettoDTO newBiglietto) {
        try{
            validateBiglietto(newBiglietto);
            BigliettiDAO bb = new BigliettiDAO();
            bb.updateTicket(convertiInEntita(newBiglietto));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("Biglietto non aggiornato");
        }
    }

    public static boolean deleteBiglietto(int id) {
        try{
            BigliettiDAO bb = new BigliettiDAO();
            bb.deleteTicket(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<BigliettoDTO> getBigliettiByUser(String userEmail){
        BigliettiDAO dao = new BigliettiDAO();
        List<Ticket> ttks = dao.getTicketByUserEmail(userEmail);
        List<BigliettoDTO> listaBiglietti = new ArrayList<>();
        for (Ticket ttk : ttks){
            listaBiglietti.add(convertiInDTO(ttk));
        }
        return listaBiglietti;
    }

    public static void generaQRcode(int id) {
        // Converti l'intero in una stringa (necessario per il QR code)
        String testo = String.valueOf(id);
        String filePath =  "../../../webapp/qrcode/"+ id + ".png";
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            // Crea il QR Code
            try {
                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                BitMatrix bitMatrix = qrCodeWriter.encode(testo, BarcodeFormat.QR_CODE, 400, 400);

                // Salva l'immagine in un file
                path = FileSystems.getDefault().getPath(filePath);
                MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            } catch (WriterException w) {
                System.out.println("Impossibile generare il QR code");
                filePath = null;
            } catch (IOException e) {
                System.out.println("Impossibile salvare il QR code");
                filePath = null;
            }
        }
    }

    public static boolean convalidaBiglietto(int id) {
        BigliettiDAO dao = new BigliettiDAO();
        Ticket ttk = dao.getTicketById(id);
        if (ttk.getStato().equals("valido")){
            try{
                validateBiglietto(convertiInDTO(ttk));
                ttk.setStato("checked");
                updateBiglietto(convertiInDTO(ttk));
                return true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                ttk.setStato("non valido");
                updateBiglietto(convertiInDTO(ttk));
                return false;
            }
        }
        else{
            return false;
        }
    }

    public static void validateBiglietto(BigliettoDTO bigliettoDTO) {
        // Verifica che l'email sia valida
        if (bigliettoDTO.getUserEmail() == null || !bigliettoDTO.getUserEmail().matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Utente non valido");
        }
        // Verifica che la data della prenotazione non sia nulla e non sia nel passato
        if (bigliettoDTO.getDataPrenotazione() == null || bigliettoDTO.getDataPrenotazione().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data non valida");
        }
        // Verifica che l'ID dell'evento sia valido
        if (GestioneEventi_MostreService.validatePrenotazione(bigliettoDTO.getEventId(), bigliettoDTO.getDataPrenotazione())) {
            throw new IllegalArgumentException("Prenotazione evento non valida");
        }
        // Verifica che il nome del titolare sia valido
        if (bigliettoDTO.getTitolare() == null || bigliettoDTO.getTitolare().trim().isEmpty()) {
            throw new IllegalArgumentException("Titolare non valido");
        }
        // Verifica che il prezzo sia positivo
        if (bigliettoDTO.getPrezzo() <= 0) {
            throw new IllegalArgumentException("Prezzo non valido");
        }
    }

    private static BigliettoDTO convertiInDTO(Ticket ticket) {
        BigliettoDTO bigliettoDTO = new BigliettoDTO();
        bigliettoDTO.setId(ticket.getId());
        bigliettoDTO.setUserEmail(ticket.getUserEmail());
        bigliettoDTO.setDataPrenotazione(ticket.getDataPrenotazione());
        bigliettoDTO.setPrezzo(ticket.getPrezzo());
        bigliettoDTO.setEventId(ticket.getEventId());
        bigliettoDTO.setTitolare(ticket.getTitolare());
        bigliettoDTO.setEventName(ticket.getEventName());
        return bigliettoDTO;
    }

    private static Ticket convertiInEntita(BigliettoDTO bigliettoDTO){
        Ticket ticket = new Ticket();
        ticket.setId(bigliettoDTO.getId());
        ticket.setUserEmail(bigliettoDTO.getUserEmail());
        ticket.setDataPrenotazione(bigliettoDTO.getDataPrenotazione());
        ticket.setPrezzo(bigliettoDTO.getPrezzo());
        ticket.setEventId(bigliettoDTO.getEventId());
        ticket.setTitolare(bigliettoDTO.getTitolare());
        ticket.setStato(null);
        ticket.setEventName(bigliettoDTO.getEventName());
        return ticket;
    }
}
