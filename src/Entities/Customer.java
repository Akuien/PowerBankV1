package Entities;

import java.util.ArrayList;

public class Customer extends User {

    private int account;
    private ArrayList<String> mortgage = new ArrayList();


    //Constructor

    public Customer(String name, String SSN, String nationality, String email, int phoneNumber, String password, int account) {
        super(name, SSN, nationality, email, phoneNumber, password);
        this.account = account;
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


}