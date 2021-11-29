package Entities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }


    public String registerEmployee(String name, String SSN, String nationality, String email, String phoneNumber, String password) {
        if (containsEmployee(SSN) || SSN.matches("[a-zA-Z]+")) {
            return "This customer is already registered";
        } else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (name.isBlank() || !(name.equals(" "))) {
            return "Please enter your first name and last name";

        } else if (!validPassword(password)) {
            return "Password is weak";

        } else if (!validEmail(email)) {
            return "Invalid email";

        } else if (!validPhoneNumber(phoneNumber)) {
            return "Invalid number";

        } else {
            Employee employee = new Employee(name, SSN, nationality, email, phoneNumber,
                    password);
            employeeList.add(employee);
            return "Customer registered successfully"; // add toString later
        }
    }

    public String registerManager(String name, String SSN, String nationality, String email, String phoneNumber, String password){
        if (name.isBlank() || !(name.equals(" "))) {
            return "Name cannot be empty";

        } else if (containsEmployee(SSN) || SSN.matches("[a-zA-Z]+")) {
            return "Employee is already registered";

        }else if (!validPassword(password)){
            return "Password is too weak";

        }else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (!validEmail(email)) {
            return "Invalid email";

        }else if (!validPhoneNumber(phoneNumber)) {
            return "Invalid number";

        } else {
            Employee employee = new Employee(name, SSN, nationality, email, phoneNumber, password);
            employeeList.add(employee);
            return "Customer registered successfully"; // add toString later
        }
    }

    public String deleteEmployee (String SSN){

        if (containsEmployee(SSN)) {
            Employee employeeToDelete = findEmployee(SSN);
            employeeList.remove(employeeToDelete);
            return "";
        }
        return "";

    }

    public Employee findEmployee (String SSN) {

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getSSN().equals(SSN)) {
                return employeeList.get(i);
            }
        }
        return null;
    }


    public boolean containsEmployee(String SSN) { // checks for existing SSN in customerList

        for (int i = 0; i < getEmployeeList().size(); i++) {
            if (getEmployeeList().get(i).getSSN().equals(SSN)) {
                return true;
            }
        }
        return false;
    }


    public boolean validPassword(String password) { // Password need to contain Uppercase, lowercase, number and be longer then 8
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

    public static boolean validPhoneNumber(String phoneNumber){
        return phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '7' && phoneNumber.length() == 11 && phoneNumber.matches("[0-9]+");
        // first char is 0 and second char is 7. and then the length of code is 11. And then we check that its in
        //between 0-9. since a phone number can have any number between 0-9 in it.
    }


}



