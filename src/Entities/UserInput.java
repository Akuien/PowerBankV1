package Entities;

import java.util.Scanner;

public class UserInput {

    public final Scanner input = new Scanner(System.in);

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
    // method that takes in a message like "Enter a long value" and returns that value.

    public long inputLong(String message){
        System.out.println(message);
        long value = input.nextLong();
        input.nextLine();
        return value;
    }

}
