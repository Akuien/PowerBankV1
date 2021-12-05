package Tests;

import Entities.Customer;
import Entities.UserManagement;
import Exceptions.EmailPasswordDoesNotExistException;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 *  Class used to test the UserManagement's class functionality
 *  author: Sabin-Daniel Sirbu
 *  version: 0.1
 */

public class UserManagementTest {

    private ArrayList<Customer> customers;

    private UserManagement um1;

    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    @Before
    public void init() throws Exception {

        customers = new ArrayList<>();

        um1 = new UserManagement(customers);

        customer1 = new Customer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);
        customer2 = new Customer("Jane", "Jackson", 19850706, "Danish", "jane.jackson@hotmail.com", "07670512902", "password123", 2);
        customer3 = new Customer("Mike", "Nicholson", 19950407, "Swedish", "john.nicholson@hotmail.com", "07213366783", "password321", 3);

    }

    @org.junit.Test
    public void getCustomerList() {

        assertEquals(um1.getCustomerList().isEmpty(), true);

        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);
        um1.registerCustomer("Jane", "Jackson", 19850706, "Danish", "jane.jackson@hotmail.com", "07670512902", "password123", 2);
        um1.registerCustomer("Mike", "Nicholson", 19950407, "Swedish", "john.nicholson@hotmail.com", "07213366783", "password321", 3);

        assertEquals(um1.getCustomerList().isEmpty(), false);

        assertEquals(um1.getCustomerList().get(0).getSSN(), customer1.getSSN());
        assertEquals(um1.getCustomerList().get(1).getSSN(), customer2.getSSN());
        assertEquals(um1.getCustomerList().get(2).getSSN(), customer3.getSSN());

    }

    @org.junit.Test
    public void registerCustomer() {

        um1 = new UserManagement(customers);

        //We add a customer object to our empty array list
        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);

        //The initial size of the array was 0
        //Now that we added a customer object in it
        //The size should be 1
        assertEquals(um1.getCustomerList().size(), 1);

        //So given that customer1 is the only customer object in the array list
        //The first element should be equal with the predefined customer1 instance
        assertEquals(um1.getCustomerList().get(0).getSSN(), customer1.getSSN());
    }

    @org.junit.Test
    public void containsCustomer() {
        um1 = new UserManagement(customers);

        //Registered a customer with the same details as customer1
        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);

        boolean isRegistered = false;

        isRegistered = um1.containsCustomer(customer1.getSSN());

        assertEquals(isRegistered, true);

        isRegistered = um1.containsCustomer(customer2.getSSN());

        assertEquals(isRegistered, false);
    }

    @org.junit.Test
    public void findSSN() {
        long tempSSN = 19800319;

        um1.registerCustomer("John", "Smith", tempSSN, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);

        Customer tempCustomer = um1.getCustomerList().get(0);
        Customer tempCustomer1 = um1.findSSN(tempSSN);

        assertEquals(tempCustomer, tempCustomer1);

        assertNotEquals(tempCustomer.getSSN(), 19800310);

    }

    //Not completed
    //To be tested after complete implementation
    @org.junit.Test
    public void validPassword() {
    }


    //Static, cannot be tested
//    @org.junit.Test
//    public void validEmail() {
//        boolean isValid = false;
//
//    }
//
//    //Static, cannot be tested
//    @org.junit.Test
//    public void validPhoneNumber() {
//    }

    @org.junit.Test
    public void deleteCustomer() {
        um1 = new UserManagement(customers);

        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);
        um1.registerCustomer("Jane", "Jackson", 19850706, "Danish", "jane.jackson@hotmail.com", "07670512902", "password123", 2);

        um1.deleteCustomer(um1.getCustomerList().get(0).getSSN());

        assertEquals(um1.getCustomerList().get(0).getSSN(), customer2.getSSN());
    }

    @org.junit.Test
    public void findCustomerBySSN() {
        //We have exactly 2 unique SSNs stored in the system: 19800319 and 19850706
        //Therefore the system shall return a customer object that has one of the two SSNs

        um1 = new UserManagement(customers);

        um1.registerCustomer("John", "Smith", customer1.getSSN(), "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);

        Customer temp1 = um1.findCustomerBySSN(customer1.getSSN());

        assertNotNull(temp1);
        assertEquals(temp1.getSSN(), customer1.getSSN());

        Customer temp2 = um1.findCustomerBySSN(customer2.getSSN());

        assertNull(temp2);

        //First we check if the method returns
    }

    @org.junit.Test
    public void findCustomerByEmail() {

        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);


        //We have exactly 2 unique SSNs stored in the system: 19800319 and 19850706
        //Therefore the system shall return a customer object that has one of the two SSNs

        Customer temp1 = um1.findCustomerByEmail(customer1.getEmail());

        assertNotEquals(temp1, null);
        assertEquals(temp1.getSSN(), customer1.getSSN());

        Customer temp2 = um1.findCustomerByEmail(customer2.getEmail());

        assertEquals(temp2, null);
    }

    @org.junit.Test
    public void findCustomerByAccessToken() throws Exception {

        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);

        //We have exactly 2 unique SSNs stored in the system: 19800319 and 19850706
        //Therefore the system shall return a customer object that has one of the two SSNs
        um1.logIn(um1.getCustomerList().get(0).getEmail(), um1.getCustomerList().get(0).getPassword());

        String tempAT = um1.getCustomerList().get(0).getAccessToken();

        Customer temp1 = um1.findCustomerByAccessToken(um1.getCustomerList().get(0).getAccessToken());

        assertNotEquals(temp1, null);
        assertEquals(temp1.getAccessToken(), tempAT);

        Customer temp2 = um1.findCustomerByAccessToken(customer2.getAccessToken());

        assertEquals(temp2, null);

    }

    @org.junit.Test
    public void logIn() throws Exception {

        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);
        um1.registerCustomer("Jane", "Jackson", 19850706, "Danish", "jane.jackson@hotmail.com", "07670512902", "password123", 2);


        //Log in customer
        um1.logIn(customer1.getEmail(), customer1.getPassword());

        //Check if customer access token is null
        //If not, the customer is logged in successfully
        assertNotNull(um1.getCustomerList().get(0).getAccessToken());

    }

    @org.junit.Test(expected = EmailPasswordDoesNotExistException.class)
    public void logIn_whenWrongEmailPasswordException_thenSuccess() throws Exception {

        um1.registerCustomer("Jane", "Jackson", 19850706, "Danish", "jane.jackson@hotmail.com", "07670512902", "password123", 2);

        Customer tempCustomer = um1.getCustomerList().get(0);

        //Log in customer with wrong password/email
        um1.logIn(tempCustomer.getEmail(), "wrongPassword");

        um1.logIn("wrongEmail@email.com", tempCustomer.getPassword());
    }

    @org.junit.Test
    public void logOut() throws Exception {
        um1.registerCustomer("John", "Smith", 19800319, "Swedish", "john.smith@hotmail.com", "07213366781", "password", 1);

        um1.logIn(customer1.getEmail(), customer1.getPassword());

        um1.logOut(um1.getCustomerList().get(0).getAccessToken());

        assertNull(um1.getCustomerList().get(0).getAccessToken());
    }
}