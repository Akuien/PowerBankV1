package Entities;

public abstract class User {

    // attributes
    private String firstName;
    private String lastName;
    private long SSN; // Username for log-in // SSN = 199702021212
    private String nationality;
    public String email;
    public String phoneNumber;
    private String password;
    private String accessToken; //This token is used for the user to be able to have all the functionalities after log in.


    // Constructor
    public User(String firstName, String lastName, long SSN, String nationality, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.nationality = nationality;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accessToken = null;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN='" + SSN + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //Setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Getters
    public String getName() {
        return firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getSSN() {
        return SSN;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
