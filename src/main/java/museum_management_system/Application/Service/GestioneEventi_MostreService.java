package museum_management_system.Application.Service;

import museum_management_system.Application.Dto.EventDTO;
import museum_management_system.Storage.Dao.EventDAO;
import museum_management_system.Storage.Model.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestioneEventi_MostreService {
    public static boolean createEvento(EventDTO eventodto){
        try{
            validateEvent(eventodto);
            Event event = convertiInEntita(eventodto);
            EventDAO dd = new EventDAO();
            dd.addEvent(event);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    public static String getEventName(int id){
        EventDAO dd = new EventDAO();
        Event evento = dd.getEventById(id);
        return evento.getName();
    }

    public static float getPrice(int id){
        EventDAO dd = new EventDAO();
        Event evento = dd.getEventById(id);
        return evento.getPriceXTicket();
    }

    public static void validateEvent(EventDTO evento){
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
        EventDAO dd = new EventDAO();
        Event evento = dd.getEventById(eventid);
        if(evento != null){
            if(evento.getPostiLiberi() >= numeroPosti){
                evento.setPostiLiberi(evento.getPostiLiberi() - numeroPosti);
                if(evento.getStartDate().isBefore(dataPrenotazione) && evento.getEndDate().isAfter(dataPrenotazione)){
                    updateEvent(convertiInDTO(evento));
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Evento non trovato");
    }

    public static boolean validatePrenotazione(int eventid, LocalDate dataPrenotazione) {
        EventDAO dd = new EventDAO();
        Event evento = dd.getEventById(eventid);
        if(evento != null){
            if(evento.getStartDate().isBefore(dataPrenotazione) && evento.getEndDate().isAfter(dataPrenotazione)){
                updateEvent(convertiInDTO(evento));
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Evento non trovato");
    }

    public static void updateEvent(EventDTO eventDTO){
        EventDAO dd = new EventDAO();
        if(!dd.updateEvent(convertiInEntita(eventDTO))){
            throw new IllegalArgumentException("Errore nell'aggiornamento dell'evento");
        }
    }

    public static EventDTO getEventById(int id){
        EventDAO dd = new EventDAO();
        Event evento = dd.getEventById(id);
        return convertiInDTO(evento);
    }

    public static List<EventDTO> getEventi(){
        EventDAO dd = new EventDAO();
        List<Event> allEventi = dd.getAllEvent();
        List<EventDTO> eventDTOS = new ArrayList<>();
        if(allEventi != null){
            for (Event event : allEventi) {
                eventDTOS.add(convertiInDTO(event));
            }
            return eventDTOS;
        }
        return null;
    }

    public static EventDTO convertiInDTO(Event evento){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(evento.getId());
        eventDTO.setName(evento.getName());
        eventDTO.setDescription(evento.getDescription());
        eventDTO.setEndDate(evento.getEndDate());
        eventDTO.setStartDate(evento.getStartDate());
        eventDTO.setPosti(evento.getPosti());
        eventDTO.setPostiLiberi(evento.getPostiLiberi());
        eventDTO.setPriceXTicket(evento.getPriceXTicket());
        return eventDTO;
    }

    public static Event convertiInEntita(EventDTO eventDTO){
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setEndDate(eventDTO.getEndDate());
        event.setStartDate(eventDTO.getStartDate());
        event.setPosti(eventDTO.getPosti());
        event.setPostiLiberi(eventDTO.getPostiLiberi());
        event.setPriceXTicket(eventDTO.getPriceXTicket());
        return event;
    }
}
