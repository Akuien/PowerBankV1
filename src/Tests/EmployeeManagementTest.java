package Tests;

import Entities.*;
import Exceptions.EmailPasswordDoesNotExistException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmployeeManagementTest {

    ArrayList<Employee> employees;
    ArrayList<CompanyStock> stocks;

    EmployeeManagement em;

    Employee employee1;
    Employee employee2;
    Employee employee3;

    CompanyStock stock1;
    CompanyStock stock2;

    @Before
    public void init() throws Exception {
        employees = new ArrayList<>();
        stocks = new ArrayList<>();

        em = new EmployeeManagement(employees, stocks);

        employee1 = new Employee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");
        employee2 = new Employee("Mary", "Payne", 19750902, "Iceland", "mary.payne@hotmail.com", "07030512902", "strongerPassword98");
        employee3 = new Employee("James", "Kent", 19840301, "Finland", "james.kent@hotmail.com", "07453366783", "strongestPassword123");

        stock1 = new CompanyStock("GGL", "Google", 112.55, 0.0, 1125500000, 10000000, 1000);
        stock2 = new CompanyStock("TSL", "Tesla", 130.55, 0.0, 1305500000, 10000000, 500);

    }

    @Test
    public void getEmployeeList() {
        assertEquals(em.getEmployeeList().isEmpty(), true);

        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");
        em.registerEmployee("Mary", "Payne", 19750902, "Iceland", "mary.payne@hotmail.com", "07030512902", "strongerPassword98");
        em.registerEmployee("James", "Kent", 19840301, "Finland", "james.kent@hotmail.com", "07453366783", "strongestPassword123");

        assertEquals(em.getEmployeeList().isEmpty(), false);

        assertEquals(em.getEmployeeList().get(0).getSSN(), employee1.getSSN());
        assertEquals(em.getEmployeeList().get(1).getSSN(), employee2.getSSN());
        assertEquals(em.getEmployeeList().get(2).getSSN(), employee3.getSSN());
    }

    @Test
    public void getCompanyStockList() {
        assertEquals(em.getCompanyStockList().isEmpty(), true);

        em.registerCompanyStock("GGL", "Google", 112.55, 0.0, 1125500000, 10000000, 1000);
        em.registerCompanyStock("TSL", "Tesla", 130.55, 0.0, 1305500000, 10000000, 500);


        assertEquals(em.getCompanyStockList().isEmpty(), false);

        assertEquals(em.getCompanyStockList().get(0).getCompanyName(), stock1.getCompanyName());
        assertEquals(em.getCompanyStockList().get(1).getCompanyName(), stock2.getCompanyName());
    }

    @Test
    public void registerEmployee() {

        //We add a customer object to our empty array list
        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");

        //The initial size of the array was 0
        //Now that we added a customer object in it
        //The size should be 1
        assertEquals(em.getEmployeeList().size(), 1);

        //So given that customer1 is the only customer object in the array list
        //The first element should be equal with the predefined customer1 instance
        assertEquals(em.getEmployeeList().get(0).getSSN(), employee1.getSSN());
    }

    @Test
    public void registerManager() {

        //We add a customer object to our empty array list
        em.registerManager("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");

        //The initial size of the array was 0
        //Now that we added a customer object in it
        //The size should be 1
        assertEquals(em.getEmployeeList().size(), 1);

        //So given that customer1 is the only customer object in the array list
        //The first element should be equal with the predefined customer1 instance
        assertEquals(em.getEmployeeList().get(0).getSSN(), employee1.getSSN());
    }

    @Test
    public void registerCompanyStock() {
        //We add a customer object to our empty array list
        em.registerCompanyStock("GGL", "Google", 112.55, 0.0, 1125500000, 10000000, 1000);

        //The initial size of the array was 0
        //Now that we added a customer object in it
        //The size should be 1
        assertEquals(em.getCompanyStockList().size(), 1);

        //So given that customer1 is the only customer object in the array list
        //The first element should be equal with the predefined customer1 instance
        assertEquals(em.getCompanyStockList().get(0).getCompanyName(), stock1.getCompanyName());
    }

    @Test
    public void containsCompany() {
        //Registered a customer with the same details as customer1
        em.registerCompanyStock("GGL", "Google", 112.55, 0.0, 1125500000, 10000000, 1000);

        boolean isRegistered = false;

        isRegistered = em.containsCompany(stock1.getCompanyName());

        assertEquals(isRegistered, true);

        isRegistered = em.containsCompany(stock2.getCompanyName());

        assertEquals(isRegistered, false);
    }

    @Test
    public void deleteEmployee() {

        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");
        em.registerEmployee("Mary", "Payne", 19750902, "Iceland", "mary.payne@hotmail.com", "07030512902", "strongerPassword98");

        em.deleteEmployee(em.getEmployeeList().get(0).getSSN());

        assertEquals(em.getEmployeeList().get(0).getSSN(), employee2.getSSN());
    }

    @Test
    public void findEmployee() {
        //We have exactly 2 unique SSNs stored in the system: 19800319 and 19850706
        //Therefore the system shall return a customer object that has one of the two SSNs

        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");

        Employee temp1 = em.findEmployee(employee1.getSSN());

        assertNotNull(temp1);
        assertEquals(temp1.getSSN(), employee1.getSSN());

        Employee temp2 = em.findEmployee(employee2.getSSN());

        assertNull(temp2);

        //First we check if the method returns
    }

    @Test
    public void containsEmployee() {

        //Registered a customer with the same details as customer1
        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");

        boolean isRegistered = false;

        isRegistered = em.containsEmployee(employee1.getSSN());

        assertEquals(isRegistered, true);

        isRegistered = em.containsEmployee(employee2.getSSN());

        assertEquals(isRegistered, false);
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

    @Test
    public void findEmployeeByAccessToken() throws Exception {
        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");

        //We have exactly 2 unique SSNs stored in the system: 19800319 and 19850706
        //Therefore the system shall return a customer object that has one of the two SSNs
        em.logIn(em.getEmployeeList().get(0).getEmail(), em.getEmployeeList().get(0).getPassword());

        String tempAT = em.getEmployeeList().get(0).getAccessToken();

        Employee temp1 = em.findEmployeeByAccessToken(em.getEmployeeList().get(0).getAccessToken());

        assertNotEquals(temp1, null);
        assertEquals(temp1.getAccessToken(), tempAT);

        Employee temp2 = em.findEmployeeByAccessToken(employee2.getAccessToken());

        assertEquals(temp2, null);
    }

    @Test
    public void findEmployeeByEmail() {
        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");


        //We have exactly 2 unique SSNs for the employees stored in the system: 19800319 and 19850706
        //Therefore the system shall return a customer object that has one of the two SSNs

        Employee temp1 = em.findEmployeeByEmail(employee1.getEmail());

        assertNotEquals(temp1, null);
        assertEquals(temp1.getSSN(), employee1.getSSN());

        Employee temp2 = em.findEmployeeByEmail(employee2.getEmail());

        assertEquals(temp2, null);
    }

    @Test
    public void logIn() throws Exception {

        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");
        em.registerEmployee("Mary", "Payne", 19750902, "Iceland", "mary.payne@hotmail.com", "07030512902", "strongerPassword98");


        //Log in customer
        em.logIn(employee1.getEmail(), employee1.getPassword());

        //Check if customer access token is null
        //If not, the customer is logged in successfully
        assertNotNull(em.getEmployeeList().get(0).getAccessToken());
    }


    @Test(expected = EmailPasswordDoesNotExistException.class)
    public void logIn_whenWrongEmailPasswordException_thenSuccess() throws Exception {

        em.registerEmployee("Mary", "Payne", 19750902, "Iceland", "mary.payne@hotmail.com", "07030512902", "strongerPassword98");

        Employee tempEmployee = em.getEmployeeList().get(0);

        //Log in customer with wrong password/email
        em.logIn(tempEmployee.getEmail(), "wrongPassword");
        em.logIn("wrongEmail@email.com", tempEmployee.getPassword());
    }


    @Test
    public void logOut() throws Exception {

        em.registerEmployee("Frank", "Shaw", 19700612, "Norway", "frank.shaw@hotmail.com", "07893366781", "strongPassword1");

        em.logIn(employee1.getEmail(), employee1.getPassword());

        em.logOut(em.getEmployeeList().get(0).getAccessToken());

        assertNull(em.getEmployeeList().get(0).getAccessToken());
    }
}