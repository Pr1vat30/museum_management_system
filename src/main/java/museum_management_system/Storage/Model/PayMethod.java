package museum_management_system.Storage.Model;

public class PayMethod {

    private int payment_id;
    private boolean is_default;
    private String card_number;
    private String card_expiry_date;
    private String card_secret_code;

    public PayMethod(int payment_id, boolean is_default, String card_number, String card_expiry_date, String card_secret_code) {
        this.payment_id = payment_id;
        this.is_default = is_default;
        this.card_number = card_number;
        this.card_expiry_date = card_expiry_date;
        this.card_secret_code = card_secret_code;
    }

    public PayMethod(String card_number, String card_expiry_date, String card_secret_code) {
        this.card_number = card_number;
        this.card_expiry_date = card_expiry_date;
        this.card_secret_code = card_secret_code;
    }

    public PayMethod() {}

    public int getPayment_id() {
        return payment_id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getCard_expiry_date() {
        return card_expiry_date;
    }

    public String getCard_secret_code() {
        return card_secret_code;
    }
}
