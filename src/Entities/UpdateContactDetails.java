package Entities;

/**
 *  Updates Customer contact details (email and phone no.)
 *  author: Sabin-Daniel Sirbu
 *  version: 0.1
 */

import java.util.Scanner;

public class UpdateContactDetails {
    private Customer customer;

    //Scanner to read input from the keyboard in the console
    private Scanner console;

    public UpdateContactDetails(Customer customer) {
        this.customer = customer;
        console = new Scanner(System.in);
    }

    //setter for the customer's email
    private void changeEmail(String email){
        customer.setEmail(email);
    }

    //setter for the customer's phone number
    private void changePhoneNumber(String phoneNumber){
        customer.setPhoneNumber(phoneNumber);
    }

    //Prompts the user the current email address
    // and the option to change it with the scanner (keyboard input)
    // the updated ph. no. will be displayed, if successful
    public void displayChangeEmail(){
        System.out.println("Current email: " + customer.getEmail());
        System.out.print("Choose new email: ");
        String input = console.nextLine();
        changeEmail(input);
        System.out.println("New email: " + customer.getEmail());
    }

    //Prompts the user the current email address
    // and the option to change it with the scanner (keyboard input)
    // the updated ph. no. will be displayed, if successful
    public void displayChangePhoneNumber(){
        System.out.println("Current phone number: " + customer.getPhoneNumber());
        System.out.print("Choose new phone number: ");
        String input = console.nextLine();
        changePhoneNumber(input);
        System.out.println("New phone number: " + customer.getPhoneNumber());
    }


}
