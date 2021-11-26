public class customer extends User{

    private int account;
    private ArrayList<String> mortgage = new ArrayList();



    //Constructor
    public customer(String name, int SSN, String nationality, long email, int phoneNumber, long password, int account) {

    }

// getter and setter
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public ArrayList<String> getMortgage() {
        return mortgage;
    }


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