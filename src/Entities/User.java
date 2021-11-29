package Entities;

public abstract class User {

    // attributes
    private String Name;
    private String SSN; // Username for log-in // SSN = 199702021212
    private String nationality;
    public String email;
    public int phoneNumber;
    private String password;


    // Constructor
    public User(String name, String SSN, String nationality, String email, int phoneNumber, String password) {
        this.Name = name;
        this.SSN = SSN;
        this.nationality = nationality;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.password = password;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", SSN=" + SSN +
                ", nationality='" + nationality + '\'' +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", password=" + password +
                '}';
    }
    //Setters

    public void setName(String name) {
        Name = name;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Getters
    public String getName() {
        return Name;
    }

    public String getSSN() {
        return SSN;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    public String getPassword() {
        return password;
    }
}
