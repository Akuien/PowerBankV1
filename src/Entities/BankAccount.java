package Entities;

public class BankAccount {

    private double balance;
    private String name;
    private long accountNumber;
    private String status;
    private long customerSSN;

    public BankAccount (double balance, String name, long accountNumber, long customerSSN){
        this.balance = balance;
        this.name = name;
        this.accountNumber = accountNumber;
        this.status = "Pending"; //so that the employee can accept this account by changing the status to "Accepted"
        this.customerSSN = customerSSN;
    }

    public String toString(){
        return "Account(" +this.name+ "): has " + this.balance + " SEK.";
    }

    public boolean equals(BankAccount bankAccount){
        return this.getCustomerSSN() == bankAccount.getCustomerSSN() && this.getAccountNumber() == bankAccount.getAccountNumber();
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public long getCustomerSSN() {
        return customerSSN;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerSSN(long customerSSN) {
        this.customerSSN = customerSSN;
    }
}