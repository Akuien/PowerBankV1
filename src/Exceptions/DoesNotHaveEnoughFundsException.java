package Exceptions;

public class DoesNotHaveEnoughFundsException extends Exception {

    public DoesNotHaveEnoughFundsException(){
        super("Funds are not enough for this operation.");
    }

}
