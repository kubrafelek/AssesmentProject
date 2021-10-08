package tapu.com.project.exceptions;

public class UrlIsAlreadyExistException extends RuntimeException{
    public UrlIsAlreadyExistException(String message) {
        super(message);
    }
}
