package Entities;

import java.util.Scanner;

public class UserInput {

    private final Scanner input = new Scanner(System.in);

    // method that takes in a message like "Enter an int value" and returns that value.
    public int inputInt(String message){

        System.out.println(message);
        int value = input.nextInt();
        input.nextLine();
        return value;

    }
    // method that takes in a message like "Enter a String value" and returns that value.
    public String inputString(String message){

        System.out.println(message);
        return input.nextLine();
    }

    // method that takes in a message like "Enter a double value" and returns that value.
    public double inputDouble(String message){
        System.out.println(message);
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }

}
