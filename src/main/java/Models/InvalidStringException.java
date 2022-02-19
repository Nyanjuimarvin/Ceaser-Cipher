package Models;

import java.security.cert.Extension;
//Throw if string doesn't match Regex
public class InvalidStringException extends Exception{
    public InvalidStringException(String exception){
        super(exception);
    }
}
