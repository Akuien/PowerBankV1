package Entities;

import Exceptions.AccessTokenDoesNotExistException;
import Exceptions.EmailPasswordDoesNotExistException;

import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Employee> employeeList = new ArrayList<>();

    public EmployeeManagement() {
        employeeList = employeeList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public EmployeeManagement(ArrayList<CompanyStock> companyStockList) {
        CompanyStockList = companyStockList;
    }

    ArrayList<CompanyStock> CompanyStockList = new ArrayList<>();

    public ArrayList<CompanyStock> getCompanyStockList(){return CompanyStockList;}


    public String registerEmployee(String firstName, String lastName, long SSN, String nationality, String email, String phoneNumber, String password) {

        if (containsEmployee(SSN)) {
            return "This customer is already registered";
        } else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (firstName.isBlank()) {
            return "Please enter your first name";

        } else if (lastName.isBlank()) {
            return "Please enter your last name";

        } else if (!validPassword(password)) {
            return "Password is weak";

        } else if (!validEmail(email)) {
            return "Invalid email";

        } else if (!validPhoneNumber(phoneNumber)) {
            return "Invalid number";

        } else {
            Employee employee = new Employee(firstName, lastName, SSN, nationality, email, phoneNumber,
                    password);
            employeeList.add(employee);
            return "Customer registered successfully"; // add toString later
        }
    }

    public String registerManager(String firstName, String lastName, long SSN, String nationality, String email, String phoneNumber, String password) {

        if (firstName.isBlank()) {
            return "Please enter your first name and last name";

        } else if (lastName.isBlank()) {
            return "Please enter your first name and last name";

        } else if (containsEmployee(SSN)) {
            return "Employee is already registered";

        } else if (!validPassword(password)) {
            return "Password is too weak";

        } else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (!validEmail(email)) {
            return "Invalid email";

        } else if (!validPhoneNumber(phoneNumber)) {
            return "Invalid number";

        } else {
            Employee employee = new Employee(firstName, lastName, SSN, nationality, email, phoneNumber, password);
            employeeList.add(employee);
            return "Customer was registered successfully"; // add toString later
        }
    }

    public String registerCompanyStock( String companyName, double tradingPrice, double valuePercentChange, double companyMarketValue, double totalCapitalShares, int totalStockHolder) {

        if (companyName.isBlank() || containsCompany(companyName)) {
            return "Name cannot be empty"+System.lineSeparator() +
                    "There is already a company with this name. Please check if the company is already registered";
        } else if(tradingPrice < 0){
            return "TradingPrice can't be negative";

        }else if (totalStockHolder < 0){
            return "total number of stockholders can't be negative";
        }else {
            CompanyStock companyStock = new CompanyStock(  companyName,  tradingPrice,  valuePercentChange, companyMarketValue, totalCapitalShares, totalStockHolder);
            CompanyStockList.add(companyStock);
            return "Company was registered successfully";
        }
    }

    public boolean containsCompany(String companyName) {

        for (int i = 0; i < getCompanyStockList().size(); i++) {
            if (getCompanyStockList().get(i).getCompanyName().equals(companyName)) {
                return true;
            }
        }
        return false;
    }



    public String deleteEmployee(long SSN) {

        if (containsEmployee(SSN)) {
            Employee employeeToDelete = findEmployee(SSN);
            employeeList.remove(employeeToDelete);
        }
        return "Employee was successfully deleted";

    }

    public Employee findEmployee(long SSN) {

        for (Employee employee : employeeList) {
            if (employee.getSSN() == SSN) {
                return employee;
            }
        }
        return null;
    }


    public boolean containsEmployee(long SSN) { // checks for existing SSN in customerList

        for (int i = 0; i < getEmployeeList().size(); i++) {
            if (getEmployeeList().get(i).getSSN() == SSN) {
                return true;
            }
        }
        return false;
    }


    public boolean validPassword(String password) { // Password need to contain Uppercase, lowercase, number and be longer then 8
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) ;
        }
        for (int n = 0; n < password.length(); n++) {
            if (password.length() <= 7) ;
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

    public static boolean validEmail(String email) { // Validates email // https://www.youtube.com/watch?v=OOdO785p3Qo

        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '7' && phoneNumber.length() == 11 && phoneNumber.matches("[0-9]+");
        // first char is 0 and second char is 7. and then the length of code is 11. And then we check that its in
        //between 0-9. since a phone number can have any number between 0-9 in it.
    }

    //Getting an employee via accessToken
    public Employee findEmployeeByAccessToken(String accessToken) {
        Employee foundEmployee = null;
        for (Employee employee : employeeList){
            if (employee.getAccessToken() == accessToken){
                foundEmployee = employee;
            }
        }
        return foundEmployee;
    }

    //Getting an employee via email
    public Employee findEmployeeByEmail(String email) {
        Employee foundEmployee = null;
        for (Employee employee : employeeList){
            if (employee.getEmail() == email){
                foundEmployee = employee;
            }
        }
        return foundEmployee;
    }

    public String logIn(String email, String password) throws Exception {
        Employee employee = findEmployeeByEmail(email);
        if (employee == null || !employee.getPassword().equals(password)) {
            throw new EmailPasswordDoesNotExistException();
        }
        employee.setAccessToken(UUID.randomUUID().toString());
        return "Employee " + employee.getSSN() + " has logged in successfully";

    }

    public void logOut(String accessToken) throws Exception{
        Employee employee = findEmployeeByAccessToken(accessToken);
        if (employee == null){
            throw new AccessTokenDoesNotExistException();
        }
        employee.setAccessToken(null);
    }
}
