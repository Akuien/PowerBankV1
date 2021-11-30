package Entities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Customer> customerList = new ArrayList<>();


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    //--------------------------------------------------------------------------
    // add home adress maybe?
    public String registerCustomer(String firstName,String lastName, String SSN, String nationality, String email, String phoneNumber, String password, int account) {
        if (containsCustomer(SSN) || SSN.matches("[a-zA-Z]+")) { //checks for letters in ssn and if existing is there
            return "This customer is already registered";
        } else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        }  else if (firstName.isBlank()) {
        return "Please enter your first name";

         } else if (lastName.isBlank()) {
        return "Please enter your last name";

        } else if (!validPassword(password)) {  // We can expend this later, number, sign !%#
            return "Password is weak, must eat more protein";

        } else if (!validEmail(email)) {
            return "Invalid email";

        } else if (!validPhoneNumber(phoneNumber)) {
            return "Invalid number";

        } else {
            Customer customer = new Customer(firstName,lastName, SSN, nationality, email, phoneNumber,
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

    public static boolean validEmail(String email){ // Validates email // https://www.youtube.com/watch?v=OOdO785p3Qo

        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    public static boolean validPhoneNumber(String phone){
        return phone.charAt(0) == '0' && phone.charAt(1) == '7' && phone.length() == 11 && phone.matches("[0-9]+");
        // first char is 0 and second char is 7. and then the length of code is 11. And then we check that its in
        //between 0-9. since a phone number can have any number between 0-9 in it.
    }


    public String deleteCustomer (String SSN){

        if (containsCustomer(SSN)) {
            Customer customerToDelete = findCustomer(SSN);
            customerList.remove(customerToDelete);
            return "";
        }
        return "";

    }

    public Customer findCustomer (String SSN) {

        for (Customer customer : customerList) {
            if (customer.getSSN().equals(SSN)) {
                return customer;
            }
        }
        return null;
    }

}