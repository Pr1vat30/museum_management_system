package museum_management_system.Storage.Model;

public class Message {

    private int message_id;
    private String title;
    private String object;
    private String content;
    private String send_date;

    public Message(int message_id, String title, String object, String content, String send_date) {
        this.message_id = message_id;
        this.title = title;
        this.object = object;
        this.content = content;
        this.send_date = send_date;
    }

    public Message(String title, String object, String content) {
        this.title = title;
        this.object = object;
        this.content = content;
    }

    public Message() {}

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getContent() {
        return content;
    }

    public void setMessage(String content) {
        this.content = content;
    }

    public String getSend_date() {
        return send_date;
    }

    public void setSend_date(String send_date) {
        this.send_date = send_date;
    }
}
