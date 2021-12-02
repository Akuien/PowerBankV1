package Exceptions;

public class EmailPasswordDoesNotExistException extends Exception{
    //We don't specify whether the password or the email are incorrect to improve security.
    public EmailPasswordDoesNotExistException(){
        super("Email or password not valid.");
    }
}
