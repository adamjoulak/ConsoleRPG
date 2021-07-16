package rpg.Exceptions;

public class InvalidArmorException extends RuntimeException{
    public InvalidArmorException(String errorMessage){
        super(errorMessage);
    }
}
