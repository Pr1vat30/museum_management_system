package museum_management_system.Storage.Model;

import java.util.Date;

public class Event {
    private int event_id;
    private Date start_date;
    private Date end_date;
    private int n_seats;
    private int n_seats_available;
    private String desc;
    private String name;

    public Event(int event_id, Date start_date, Date end_date, int n_seats, int n_seats_available, String desc, String name) {
        this.event_id = event_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.n_seats = n_seats;
        this.n_seats_available = n_seats_available;
        this.desc = desc;
        this.name = name;
    }

    public Event(Date start_date, Date end_date, int n_seats, int n_seats_available, String desc, String name) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.n_seats = n_seats;
        this.n_seats_available = n_seats_available;
        this.desc = desc;
        this.name = name;
    }

    public Event() {}

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getN_seats() {
        return n_seats;
    }

    public void setN_seats(int n_seats) {
        this.n_seats = n_seats;
    }

    public int getN_seats_available() {
        return n_seats_available;
    }

    public void setN_seats_available(int n_seats_available) {
        this.n_seats_available = n_seats_available;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
