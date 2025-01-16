package museum_management_system.Storage.Model;

public class Staff {

    private int staff_id;
    private String staff_cf;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Double salary;
    private String contract;

    public Staff(int staff_id, String staff_cf, String name, String surname, String email, String password, Double salary, String contract) {
        this.staff_id = staff_id;
        this.staff_cf = staff_cf;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.contract = contract;
    }

    public Staff(String staff_cf, String name, String surname, String email, String password, Double salary, String contract) {
        this.staff_cf = staff_cf;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.contract = contract;
    }

    public Staff() {}

    public String getRole() { return "staff"; }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_cf() {
        return staff_cf;
    }

    public void setStaff_cf(String staff_cf) {
        this.staff_cf = staff_cf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
