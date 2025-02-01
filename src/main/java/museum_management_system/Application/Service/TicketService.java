package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.TicketDao;
import museum_management_system.Storage.Model.Ticket;

import java.util.List;
import java.util.Map;

public class TicketService {

    public List<Ticket> save(Map<String, Object> jsonMap) {

        Ticket ticket = new Ticket(
                (String) jsonMap.get("ticket_type"),
                Double.parseDouble((String) jsonMap.get("ticket_price")),
                Integer.parseInt((String) jsonMap.get("event_id"))
        );

        TicketDao ticketDao = new TicketDao();
        ticketDao.InsertTicket(ticket);
        return ticketDao.GetTickets();
    }

    public List<Ticket> get() {
        TicketDao ticketDao = new TicketDao();
        return ticketDao.GetTickets();
    }
}
