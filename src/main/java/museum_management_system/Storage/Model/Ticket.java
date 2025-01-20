package museum_management_system.Storage.Model;

public class Ticket {

    private int ticket_id;
    private String type;
    private Double price;
    private int event_id;

    public Ticket(int ticket_id, String type, Double price, int event_id) {
        this.ticket_id = ticket_id;
        this.type = type;
        this.price = price;
        this.event_id = event_id;
    }

    public Ticket(String type, Double price, int event_id) {
        this.type = type;
        this.price = price;
        this.event_id = event_id;
    }

    public Ticket() {}

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }
}
