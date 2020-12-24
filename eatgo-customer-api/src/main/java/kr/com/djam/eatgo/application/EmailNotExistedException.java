package kr.com.djam.eatgo.application;

public class EmailNotExistedException extends RuntimeException{
    public EmailNotExistedException(String email) {
        super("Email is not registered: "+email);
    }
}
