package museum_management_system.Application.Service;

import museum_management_system.Application.Dto.MostraDTO;
import museum_management_system.Storage.Dao.MostraDAO;
import museum_management_system.Storage.Model.Mostra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestioneMostreService {
    public static boolean createMostra(MostraDTO eventodto){
        try{
            validateMostra(eventodto);
            Mostra mostra = convertiInEntita(eventodto);
            MostraDAO dd = new MostraDAO();
            dd.addEvent(mostra);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public static String getMostraName(int id){
        MostraDAO dd = new MostraDAO();
        Mostra evento = dd.getEventById(id);
        return evento.getName();
    }

    public static float getPrice(int id){
        MostraDAO dd = new MostraDAO();
        Mostra evento = dd.getEventById(id);
        return evento.getPriceXTicket();
    }

    public static void validateMostra(MostraDTO evento){
        LocalDate startDate = evento.getStartDate();
        LocalDate endDate = evento.getEndDate();
        if(startDate.isAfter(endDate)){
            throw new IllegalArgumentException("Date di inizio e fine non valide");
        }
        if(evento.getPostiLiberi() < 1){
            throw new IllegalArgumentException("Numero di posti non valido");
        }
    }
    public static boolean validatePrenotazione(int eventid, LocalDate dataPrenotazione, int numeroPosti) {
        MostraDAO dd = new MostraDAO();
        Mostra evento = dd.getEventById(eventid);
        if(evento != null){
            if(evento.getPostiLiberi() >= numeroPosti){
                evento.setPostiLiberi(evento.getPostiLiberi() - numeroPosti);
                if(evento.getStartDate().isBefore(dataPrenotazione) && evento.getEndDate().isAfter(dataPrenotazione)){
                    updateMostra(convertiInDTO(evento));
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Evento non trovato");
    }

    public static boolean validatePrenotazione(int eventid, LocalDate dataPrenotazione) {
        MostraDAO dd = new MostraDAO();
        Mostra evento = dd.getEventById(eventid);
        if(evento != null){
            if(evento.getStartDate().isBefore(dataPrenotazione) && evento.getEndDate().isAfter(dataPrenotazione)){
                updateMostra(convertiInDTO(evento));
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Evento non trovato");
    }

    public static void updateMostra(MostraDTO mostraDTO){
        MostraDAO dd = new MostraDAO();
        if(!dd.updateEvent(convertiInEntita(mostraDTO))){
            throw new IllegalArgumentException("Errore nell'aggiornamento dell'evento");
        }
    }

    public static MostraDTO getMostraById(int id){
        MostraDAO dd = new MostraDAO();
        Mostra evento = dd.getEventById(id);
        return convertiInDTO(evento);
    }

    public static List<MostraDTO> getAllMostre(){
        MostraDAO dd = new MostraDAO();
        List<Mostra> allEventi = dd.getAllEvent();
        List<MostraDTO> mostraDTOS = new ArrayList<>();
        if(allEventi != null){
            for (Mostra mostra : allEventi) {
                mostraDTOS.add(convertiInDTO(mostra));
            }
            return mostraDTOS;
        }
        return null;
    }

    public static MostraDTO convertiInDTO(Mostra evento){
        MostraDTO mostraDTO = new MostraDTO();
        mostraDTO.setId(evento.getId());
        mostraDTO.setName(evento.getName());
        mostraDTO.setDescription(evento.getDescription());
        mostraDTO.setEndDate(evento.getEndDate());
        mostraDTO.setStartDate(evento.getStartDate());
        mostraDTO.setPosti(evento.getPosti());
        mostraDTO.setPostiLiberi(evento.getPostiLiberi());
        mostraDTO.setPriceXTicket(evento.getPriceXTicket());
        return mostraDTO;
    }

    public static Mostra convertiInEntita(MostraDTO mostraDTO){
        Mostra mostra = new Mostra();
        mostra.setId(mostraDTO.getId());
        mostra.setName(mostraDTO.getName());
        mostra.setDescription(mostraDTO.getDescription());
        mostra.setEndDate(mostraDTO.getEndDate());
        mostra.setStartDate(mostraDTO.getStartDate());
        mostra.setPosti(mostraDTO.getPosti());
        mostra.setPostiLiberi(mostraDTO.getPostiLiberi());
        mostra.setPriceXTicket(mostraDTO.getPriceXTicket());
        return mostra;
    }
}
