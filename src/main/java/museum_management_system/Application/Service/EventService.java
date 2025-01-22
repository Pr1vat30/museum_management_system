package museum_management_system.Application.Service;

import museum_management_system.Storage.Dao.EventDao;
import museum_management_system.Storage.Model.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class EventService {

    public List<Event> save(Map<String, Object> jsonMap) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Event event = null;
        try {
            event = new Event(
                    dateFormat.parse((String) jsonMap.get("start_date")),
                    dateFormat.parse((String) jsonMap.get("end_date")),
                    Integer.parseInt((String) jsonMap.get("seats")),
                    Integer.parseInt((String) jsonMap.get("seats")),
                    (String) jsonMap.get("desc"),
                    (String) jsonMap.get("name")
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        EventDao eventDao = new EventDao();
        jsonMap.put("event_id", String.valueOf(eventDao.insertEvent(event)));

        TicketService ticketService = new TicketService();
        ticketService.save(jsonMap);

        return eventDao.GetEvents();
    }

    public List<Event> delete(int event_id) {
        EventDao eventDao = new EventDao();
        eventDao.DeleteEvent(event_id);
        return eventDao.GetEvents();
    }

    public List<Event> get() {
        EventDao eventDao = new EventDao();
        return eventDao.GetEvents();
    }

    public List<Event> update(Map<String, Object> jsonMap) {
        return null;
    }
}
