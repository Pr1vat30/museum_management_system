package museum_management_system.Storage.Model;

public class Admin {
    private int adminId;
    private String adminCf;
    private String adminName;
    private String adminSurname;
    private String adminPassword;
    private String adminEmail;
    private String adminPhone;
    private double adminSalary;

    public Admin(int id, String cf, String name, String surname, String password, String email, String phone, double salary) {
        this.adminId = id;
        this.adminCf = cf;
        this.adminName = name;
        this.adminSurname = surname;
        this.adminPassword = password;
        this.adminEmail = email;
        this.adminPhone = phone;
        this.adminSalary = salary;
    }

    public Admin(String cf, String name, String surname, String password, String email, String phone, double salary) {
        this.adminCf = cf;
        this.adminName = name;
        this.adminSurname = surname;
        this.adminPassword = password;
        this.adminEmail = email;
        this.adminPhone = phone;
        this.adminSalary = salary;
    }

    public Admin() {}

    public String getRole() { return "admin"; }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminCf() {
        return adminCf;
    }

    public void setAdminCf(String adminCf) {
        this.adminCf = adminCf;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSurname() {
        return adminSurname;
    }

    public void setAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public double getAdminSalary() {
        return adminSalary;
    }

    public void setAdminSalary(double adminSalary) {
        this.adminSalary = adminSalary;
    }
}
