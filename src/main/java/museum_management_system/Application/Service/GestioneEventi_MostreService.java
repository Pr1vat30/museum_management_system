package museum_management_system.Application.Service;

import museum_management_system.Application.Dto.EventDTO;
import museum_management_system.Storage.Dao.EventDAO;
import museum_management_system.Storage.Model.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestioneEventi_MostreService {
    public static String getEventName(int id){
        EventDAO dd = new EventDAO();
        Event evento = dd.getEventById(id);
        return evento.getName();
    }

    public static float getPrice(long idEvent){
        //ottiene il prezzo del biglietto per l'evento dal database
        return 10;
    }

    public static boolean validatePrenotazione(long idEvento, LocalDate dataPrenotazione, int numeroPosti) {
        //Ottiene l'evento tramite l'id dal DAO e verifica che esista
        //verifica se ci sono posti liberi e se sono sufficienti
        //verifica se la data è compatibile con l'evento
        //se è possibile prenotare restituisce true
        //altrimenti false
        return true;
    }
    public static boolean validatePrenotazione(long idEvento, LocalDate dataPrenotazione) {
        //Fa la stessa cosa ma senza valutare i posti disponibili
        return true;
    }

    public static List<EventDTO> getEventi(){
        //Ottiene la lista di eventi che sono disponibili a partire dalla data attuale
        //li converte in eventi DTO
        //li restituisce
        List<EventDTO> eventi = new ArrayList<>();
        Event evento = new Event();
        evento.setId(1);
        evento.setName("Evento1");
        evento.setStartDate(LocalDate.now());
        evento.setEndDate(LocalDate.now().plusDays(1));
        eventi.add(convertiInDTO(evento));
        return eventi;
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
