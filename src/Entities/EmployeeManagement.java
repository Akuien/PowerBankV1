package Entities;

import java.util.ArrayList;

public class EmployeeManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }


    public String registerEmployee(String name, String SSN, String nationality, String email, int phoneNumber, String password) {
        if (containsEmployee(SSN) || SSN.matches("[a-zA-Z]+")) {
            return "This customer is already registerd";
        } else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (name.isBlank()) {
            return "Please enter your first name and last name";

        } else if (!validPassword(password)) {  // We can expend this later, number, sign !%#
            return "Password is weak, must eat more protin";

        } else if (email.length() < 8) {
            return "Invalid email";

        } else if (phoneNumber < 10) {
            return "Invalid number";

        } else {
            Employee employee = new Employee(name, SSN, nationality, email, phoneNumber,
                    password);
            employeeList.add(employee);
            return "Customer registered successfully"; // add toString later
        }
    }

    public String registerManager(String name, String SSN, String nationality, String email, int phoneNumber, String password){
        if (name.isBlank()) {
            return "Name cannot be empty";

        } else if (containsEmployee(SSN) || SSN.matches("[a-zA-Z]+")) {
            return "Employee is already registered";

        }else if (!validPassword(password)){
            return "Password is too weak";

        }else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (email.length() < 8) {
            return "Invalid email";

        }else if (phoneNumber < 10) {
            return "Invalid number";

        } else {
            Employee employee = new Employee(name, SSN, nationality, email, phoneNumber, password);
            employeeList.add(employee);
            return "Customer registered successfully"; // add toString later
        }
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


}



