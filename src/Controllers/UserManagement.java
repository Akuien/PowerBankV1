public class UserManagment{


    // -----------------------------ARRAYLISTS----------------------------------

    ArrayList<customer> customerList = new ArrayList<>();

    public ArrayList<SSN> getCustomerList() {
        return customerList;
    }


    // add home adress maybe?
    public String registerCustomer(String name, int SSN, String nationality, long email, int phoneNumber, long password, int account){
        if (containsSSN(SSN) {
            return "This customer is already registerd"
        }else if (nationality.isEmpty()){
            return "Please enter the cuntry you are currently living in"

        } else if (password.size() < 8) {  // We can expend this later, number, sign !%#
        return "Password is weak, must eat more protin"

        } else if (email.size() < 8 || ) {
            return "Invalid email"

        }else if (phoneNumber.size() < 10) {
            return "Invalid number"

        }else {
            Customer customer = new Customer(String name, int SSN, String nationality,long email, int phoneNumber,
            long password, int account);
            customerList.add(customer);
            return "Customer registerd successfully" // add toString later
        }
    }

    public boolean containsSSN(int SSN) // checks for existing SSN in customerList

        for (int i = 0; i < getCustomerList().size(); i++) {
        if (getCustomerList().get(i).getSSN().equals(SSN)) {
            return true;
        }
    }
        return false;
}

}