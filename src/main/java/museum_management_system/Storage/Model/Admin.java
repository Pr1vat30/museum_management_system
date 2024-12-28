package museum_management_system.Storage.Model;

public class Admin {
    private int admin_id;
    private String admin_cf;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phone;
    private double salary;

    public Admin(int id, String cf, String name, String surname, String password, String email, String phone, double salary) {
        this.admin_id = id;
        this.admin_cf = cf;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public Admin(String cf, String name, String surname, String password, String email, String phone, double salary) {
        this.admin_cf = cf;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public Admin() {}

    public String getRole() { return "admin"; }

    public int getId() {
        return admin_id;
    }

    public void setId(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_cf() {
        return admin_cf;
    }

    public void setAdmin_cf(String admin_cf) {
        this.admin_cf = admin_cf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
