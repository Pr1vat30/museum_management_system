package museum_management_system.Storage.Model;

public class Ticket {

    private int ticket_id;
    private String ticket_type;
    private Double ticket_price;
    private int event_id;

    public Ticket(int ticket_id, String ticket_type, Double ticket_price, int event_id) {
        this.ticket_id = ticket_id;
        this.ticket_type = ticket_type;
        this.ticket_price = ticket_price;
        this.event_id = event_id;
    }

    public Ticket(String ticket_type, Double ticket_price) {
        this.ticket_type = ticket_type;
        this.ticket_price = ticket_price;
    }

    public Ticket() {}

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

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }
}
