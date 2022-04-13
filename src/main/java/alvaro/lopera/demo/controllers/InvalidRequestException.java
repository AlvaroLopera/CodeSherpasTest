package alvaro.lopera.demo.controllers;

public class InvalidRequestException extends RuntimeException {
    
    public InvalidRequestException ( String msn ) {
        super(msn);
    }

}
