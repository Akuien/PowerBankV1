package Entities;

import java.util.ArrayList;

public class Customer extends User implements BuySellShares {

    private int account;
    private ArrayList<Mortgage> mortgages = new ArrayList();
    private ArrayList<BankAccount> bankAccounts = new ArrayList();
    private ArrayList<CompanyStock> ownedCompanyStock = new ArrayList();


    //Constructor

    public Customer(String firstName, String lastName, long SSN, String nationality, String email, String phoneNumber, String password, int account) {
        super(firstName,lastName,SSN,nationality,email,phoneNumber,password);
        this.account = account;
    }

    // getter and setter
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public ArrayList<Mortgage> getMortgage() {
        return mortgages;
    }
    public ArrayList<BankAccount> getBankAccounts(){return bankAccounts;}


    @Override
    public void buyShares() {

    }

    @Override
    public void sellShares() {

    }
}