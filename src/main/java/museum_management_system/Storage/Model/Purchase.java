package museum_management_system.Storage.Model;

import java.sql.Date;

public class Purchase {

    private int purchase_id;
    private int user_id;
    private int ticket_id;
    private int event_id;

    private String event_name;
    private String ticket_type;
    private Double ticket_price;
    private Date purchase_date;

    public Purchase(int user_id, int ticket_id, int event_id) {
        this.user_id = user_id;
        this.ticket_id = ticket_id;
        this.event_id = event_id;
    }

    public Purchase(String eventName, String ticketType, double ticket_price, Date purchase_date) {
        this.event_name = eventName;
        this.ticket_type = ticketType;
        this.ticket_price = ticket_price;
        this.purchase_date = purchase_date;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
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

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }
}
