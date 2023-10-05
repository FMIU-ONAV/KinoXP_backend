package dk.kea.kinoxp_rest.exception;

public class CategoryNotFoundException extends RuntimeException
{
    public CategoryNotFoundException(String message){
        super(message);
    }
}
