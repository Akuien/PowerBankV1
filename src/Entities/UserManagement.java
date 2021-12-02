package Entities;

import Exceptions.AccessTokenDoesNotExistException;
import Exceptions.EmailPasswordDoesNotExistException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.UUID; //library for creating the token which is a String of alphanumeric characters that will differentiate the users that are logged in or logged out.
public class UserManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Customer> customerList = new ArrayList<>();


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    //---------------------------------------------------------------------------

    public String registerCustomer(String firstName,String lastName, long SSN, String nationality, String email, String phoneNumber, String password, int account) {
        if (containsCustomer(SSN)) { //checks for letters in ssn and if existing is there
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

    public boolean containsCustomer(long SSN) { // checks for existing SSN in customerList

        for (int i = 0; i < getCustomerList().size(); i++) {
            if (getCustomerList().get(i).getSSN() == SSN) {
                return true;
            }
        }
        return false;
    }


    public Customer findSSN(long SSN) {

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getSSN() == SSN) {
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


    public String deleteCustomer (long SSN){

        if (containsCustomer(SSN)) {
            Customer customerToDelete = findCustomerBySSN(SSN);
            customerList.remove(customerToDelete);
            return "";
        }
        return "";

    }

    public Customer findCustomerBySSN (long SSN) {
        for (Customer customer : customerList) {
            if (customer.getSSN() == SSN) {
                return customer;
            }
        }
        return null;
    }

    //Function for getting a Customer via email
    public Customer findCustomerByEmail(String email){
        Customer foundCustomer = null;
        for (Customer currentCustomer : customerList){
            if (currentCustomer.getEmail().equals(email)){
                foundCustomer = currentCustomer;
            }
        }
        return foundCustomer;
    }

    //Function for getting a Customer via AccessToken
    public Customer findCustomerByAccessToken(String accessToken){
        Customer foundCustomer = null;
        for (Customer currentCustomer : customerList){
            if (currentCustomer.getAccessToken().equals(accessToken)){
                foundCustomer = currentCustomer;
            }
        }
        return foundCustomer;
    }

    public String logIn(String email, String password) throws Exception{
        Customer customer = findCustomerByEmail(email);
        if (customer == null || !customer.getPassword().equals(password)){
            throw new EmailPasswordDoesNotExistException();
        }
        customer.setAccessToken(UUID.randomUUID().toString());
        return "User " + customer.getSSN() + " has logged in successfully";
        //If we plan on using javaFX we may need to return the token instead of a String
    }

    public void logOut(String accessToken) throws Exception {
        Customer customer = findCustomerByAccessToken(accessToken);
        if (customer == null){
            throw new AccessTokenDoesNotExistException();
        }
        customer.setAccessToken(null);
        //When the customer has no accessToken then is logged out
    }



}