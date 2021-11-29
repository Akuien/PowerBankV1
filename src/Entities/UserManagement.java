package Entities;

import java.util.ArrayList;

public class UserManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Customer> customerList = new ArrayList<Customer>();


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    //--------------------------------------------------------------------------
    // add home adress maybe?
    public String registerCustomer(String name, String SSN, String nationality, String email, int phoneNumber, String password, int account) {
        if (containsCustomer(SSN) || SSN.matches("[a-zA-Z]+")) { //checks for letters in ssn and if existing is there
            return "This customer is already registerd";
        } else if (nationality.isEmpty()) {
            return "Please enter the cuntry you are currently living in";

        } else if (name.isBlank()) {
            return "Please enter your first name and last name";

        } else if (!validPassword(password)) {  // We can expend this later, number, sign !%#
            return "Password is weak, must eat more protin";

        } else if (email.length() < 8) {
            return "Invalid email";

        } else if (phoneNumber < 10) {
            return "Invalid number";

        } else {
            Customer customer = new Customer(name, SSN, nationality, email, phoneNumber,
                    password, account);
            customerList.add(customer);
            return "Customer registered successfully"; // add toString later
        }
    }

    public boolean containsCustomer(String SSN) { // checks for existing SSN in customerList

        for (int i = 0; i < getCustomerList().size(); i++) {
            if (getCustomerList().get(i).getSSN().equals(SSN)) {
                return true;
            }
        }
        return false;
    }

    public Customer findSSN(String SSN) {

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getSSN().equals(SSN)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    public boolean validPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) ;
        }
        for (int n =0; n < password.length(); n++){
            if (password.length() <= 7);
        }
        for (int p = 0; p < password.length(); p++) {
            if (Character.isLowerCase(password.charAt(p))) ;
        }
        for (int x = 0; x < password.length(); x++) {
            if (Character.isDigit(password.charAt(x))) {
            }
        }
        return true;
    }

}