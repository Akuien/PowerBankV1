package Entities;

import java.util.ArrayList;

public class EmployeeManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }


    public String registerEmployee(String name, String SSN, String nationality, long email, int phoneNumber, long password) {
        if (containsEmployee(SSN)) {
            return "This customer is already registerd";
        } else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (name.isBlank()) {
            return "Please enter your first name and last name";

        } else if (password < 8) {  // We can expend this later, number, sign !%#
            return "Password is weak, must eat more protin";

        } else if (email < 8) {
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

    public String registerManager(String name, String SSN, String nationality, long email, int phoneNumber, long password){
        if (name.isBlank()){
            return "Name cannot be empty";

        } if (containsEmployee(SSN)){
            return "Employee is already registered";

        }else if (password < 8){
            return "Password is too weak";

        }else if (nationality.isEmpty()) {
            return "Please enter the country you are currently living in";

        } else if (email < 8) {
            return "Invalid email";

        }else if (phoneNumber < 10) {
            return "Invalid number";

        } else {
            Employee employee = new Employee(name, SSN, nationality, email, phoneNumber,
                    password);
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


}



