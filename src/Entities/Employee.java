package Entities;

import java.util.ArrayList;

public class Employee extends User{

    private ArrayList<BankAccount> bankAccounts = new ArrayList();
    private UserManagement userManagement;

    public Employee(String firstName, String lastName, long SSN, String nationality, String email, String phoneNumber, String password) {

        super(firstName,lastName,SSN,nationality,email,phoneNumber,password);

    }

    // method for adding bank accounts

    public String addBankAccount(double balance, String name, long accountNumber, long customerSSN) {
        if (! userManagement.containsCustomer(customerSSN)) {
            return "Bank accounts can only be added to registered customers";
        } else if (balance < 0.0) { //should have 2 decimals, System.out.printf("%.2f", val); where val = balance
            return "Please enter valid balance";
        } else if (name.isBlank()) {
            return "Please enter the name of the account";
        } else if (! validAccountNumber(accountNumber)) {
            return "Account number is not valid, please use 4 digits";
        } else {
            BankAccount bankAccount = new BankAccount(balance, name, accountNumber, customerSSN);
            bankAccounts.add(bankAccount);
            return "Account was successfully created";
        }

    }

    public boolean validAccountNumber(long accountNumber){
        int length = (int) (Math.log10(accountNumber) + 1);
        if (length == 4){
            return true;
        } else {
            return false;
        }
    }

}

