package Entities;

public class Transaction {

    private int transactionID;
    private BankAccount bankAccount1;
    private BankAccount bankAccount2;
    private int transactionDate;



    public int getTransactionID() {
        return transactionID;
    }

    public BankAccount getBankAccount1() {
        return bankAccount1;
    }

    public BankAccount getBankAccount2() {
        return bankAccount2;
    }

    public int getTransactionDate() {
        return transactionDate;
    }


    public void setTransactionID(int transactionID) {this.transactionID = transactionID; }

    public void setBankAccount1(BankAccount bankAccount1) {
        this.bankAccount1 = bankAccount1;
    }

    public void setBankAccount2(BankAccount bankAccount2) {
        this.bankAccount2 = bankAccount2;
    }

    public void setTransactionDate(int transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", bankAccount1=" + bankAccount1 +
                ", bankAccount2=" + bankAccount2 +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

