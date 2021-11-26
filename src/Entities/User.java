public abstract class User {

// attributes
    private String Name;
    private int SSN; // Username for log-in // SSN = 199702021212
    private String nationality;
    public long email;
    public int phoneNumber;
    private long password;


// Constructor
    public User(String name, int SSN, String nationality, long email, int phoneNumber, long password) {
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

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setEmail(long email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public void setPassword(long password) {
        this.password = password;
    }
// Getters
    public String getName() {
        return Name;
    }

    public int getSSN() {
        return SSN;
    }

    public String getNationality() {
        return nationality;
    }

    public long getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    public long getPassword() {
        return password;
    }
}