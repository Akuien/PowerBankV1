package Exceptions;

public class AccessTokenDoesNotExistException extends Exception{

    public AccessTokenDoesNotExistException(){
        super("Access token not valid.");
    }
}
