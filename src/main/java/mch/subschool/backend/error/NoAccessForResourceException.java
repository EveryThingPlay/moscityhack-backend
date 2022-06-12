package mch.subschool.backend.error;

public class NoAccessForResourceException extends RuntimeException{
    public NoAccessForResourceException() {
        super("Access fo resource error");
    }
}
