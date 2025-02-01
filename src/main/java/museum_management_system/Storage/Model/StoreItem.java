package museum_management_system.Storage.Model;

public class StoreItem {

    private int event_id;
    private String event_name;
    private int ticket_id;
    private String ticket_type;
    private Double ticket_price;
    private int n_seats_available;

    public StoreItem(int event_id, String event_name, int ticket_id, String ticket_type, Double ticket_price, int n_seats_available) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.ticket_id = ticket_id;
        this.ticket_type = ticket_type;
        this.ticket_price = ticket_price;
        this.n_seats_available = n_seats_available;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    public Double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(Double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public int getN_seats_available() {
        return n_seats_available;
    }

    public void setN_seats_available(int n_seats_available) {
        this.n_seats_available = n_seats_available;
    }
}
