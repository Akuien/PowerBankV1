import java.util.ArrayList;

public class UserManagement {


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<Customer> customerList = new ArrayList<Customer>();


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    //--------------------------------------------------------------------------
    // add home adress maybe?
    public String registerCustomer(String name, String SSN, String nationality, long email, int phoneNumber, long password, int account) {
        if (containsCustomer(SSN) || SSN.matches("[a-zA-Z]+")) { //checks for letters in ssn and if existing is there
            return "This customer is already registerd";
        } else if (nationality.isEmpty()) {
            return "Please enter the cuntry you are currently living in";

        } else if (name.isBlank()) {
            return "Please enter your first name and last name";

        } else if (password < 8) {  // We can expend this later, number, sign !%#
            return "Password is weak, must eat more protin";

        } else if (email < 8) {
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
}